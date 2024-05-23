package com.msig.transaction.service;


import com.msig.transaction.dto.MasterSppDTO;
import com.msig.transaction.dto.MasterStudentDTO;
import com.msig.transaction.entity.MasterSpp;
import com.msig.transaction.entity.SppTransaction;
import com.msig.transaction.repository.MasterSppRepository;
import com.msig.transaction.repository.SppTransactionRepository;
import com.msig.transaction.repository.UserServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MasterSppService {

    private final MasterSppRepository sppRepository;
    private final UserServiceClient serviceClient;
    private final SppTransactionRepository transactionRepository;


    public void save (MasterSppDTO param){
        MasterSpp data = new MasterSpp();
        data.setJumlahSpp(param.getJumlahSpp());
        data.setUserName(param.getUserName());

        sppRepository.save(data);
    }

    public MasterStudentDTO getAllSppDetail(String userName){
        MasterStudentDTO result = serviceClient.getStudent(userName).toDTO();
        MasterSppDTO sppDTO = sppRepository.findByUserName(userName).toDTO();
        List<SppTransaction> dataPembayaran = transactionRepository.findByUserName(userName);
        Map<Integer, List<Integer>> yearMonthMap =this.sumMonth();


        if(!dataPembayaran.isEmpty()){
            for(SppTransaction  x : dataPembayaran){
                this.removeMonth(x.getSppYear(),x.getSppMonth(),yearMonthMap);
            }
        }


        int numberOfMonths=0;
        StringBuilder totalDate = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : yearMonthMap.entrySet()) {
            List<Integer> months = entry.getValue();
            numberOfMonths += months.size();
            totalDate.append("Tahun: ").append(entry.getKey()).append(" Bulan: ").append(entry.getValue());
        }



        sppDTO.setDate(totalDate.toString());
        result.setTotal(sppDTO.getJumlahSpp()*numberOfMonths);
        result.setDetailSpp(sppDTO);
        return result;
    }

    public Map<Integer, List<Integer>> sumMonth(){
        // Tentukan tahun awal
        int startYear = 2024;

        // Dapatkan tahun dan bulan saat ini
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        // Buat Map untuk menyimpan tahun sebagai kunci dan daftar bulan sebagai nilai
        Map<Integer, List<Integer>> yearMonthMap = new HashMap<>();

        // Isi Map dengan tahun dan bulan dari tahun awal hingga tahun saat ini
        for (int year = startYear; year <= currentYear; year++) {
            List<Integer> monthsList = new ArrayList<>();
            if (year == currentYear) {
                // Tambahkan bulan dari 1 hingga bulan saat ini untuk tahun berjalan
                for (int month = 1; month <= currentMonth; month++) {
                    monthsList.add(month);
                }
            } else {
                // Tambahkan semua bulan dari 1 hingga 12 untuk tahun-tahun sebelumnya
                for (int month = 1; month <= 12; month++) {
                    monthsList.add(month);
                }
            }
            yearMonthMap.put(year, monthsList);
        }

        // Cetak hasil Map
        for (Map.Entry<Integer, List<Integer>> entry : yearMonthMap.entrySet()) {
            System.out.println("Year: " + entry.getKey() + " Months: " + entry.getValue());
        }

        return yearMonthMap;
    }


    public Map<Integer, List<Integer>> removeMonth(int tahun, int bulan,Map<Integer, List<Integer>> yearMonthMap) {
        if (yearMonthMap.containsKey(tahun)) {
            List<Integer> bulanList = yearMonthMap.get(tahun);
            if (bulanList.contains(bulan)) {
                bulanList.remove(Integer.valueOf(bulan));
                if (bulanList.isEmpty()) {
                    yearMonthMap.remove(tahun);
                }
            }
        }
        return yearMonthMap;
    }

}
