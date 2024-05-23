package com.msig.transaction.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        // Contoh data Map
        Map<Integer, List<Integer>> yearMonthMap = new HashMap<>();
        yearMonthMap.put(2021, new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        yearMonthMap.put(2022, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)));
        yearMonthMap.put(2023, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        yearMonthMap.put(2024, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        // Input tahun dan bulan yang ingin dihapus
        int tahun = 2022;
        int bulan = 5;

        // Hapus kunci dan nilai dari Map jika ada
        if (yearMonthMap.containsKey(tahun)) {
            List<Integer> bulanList = yearMonthMap.get(tahun);
            if (bulanList.contains(bulan)) {
                bulanList.remove(Integer.valueOf(bulan));
                if (bulanList.isEmpty()) {
                    yearMonthMap.remove(tahun);
                }
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Bulan tidak ditemukan untuk tahun tersebut.");
            }
        } else {
            System.out.println("Tahun tidak ditemukan.");
        }

        // Cetak hasil Map setelah dihapus
        System.out.println("Hasil setelah penghapusan:");
        for (Map.Entry<Integer, List<Integer>> entry : yearMonthMap.entrySet()) {
            System.out.println("Year: " + entry.getKey() + " Months: " + entry.getValue());
        }
    }
}
