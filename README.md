Connection For Database  =  localhost:5432/msig
database name = msig
port = 5432

Script for Database :

CREATE SEQUENCE public.master_user_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE;

CREATE SEQUENCE public.master_student_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE;

CREATE SEQUENCE public.spp_transaction_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE; 

CREATE SEQUENCE public.master_spp_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE;

CREATE TABLE public.master_spp ( id int8 NOT NULL, user_name varchar NOT NULL, jumlah_spp int8 NULL, CONSTRAINT master_spp_pk PRIMARY KEY (id) );

CREATE TABLE public.master_user ( id int8 NOT NULL, "password" varchar NULL, user_name varchar NULL );

CREATE TABLE public.spp_transaction ( id int8 NOT NULL, user_name varchar NOT NULL, spp_month int4 NULL, created_date date NULL, created_by varchar NULL, spp_year int4 NULL, CONSTRAINT spp_transaction_pk PRIMARY KEY (id) );

CREATE TABLE public.master_student ( id int8 NOT NULL, full_name varchar NULL, address varchar NULL, parent_name varchar NULL, grade int4 NULL, user_name varchar NOT NULL, CONSTRAINT master_student_pk PRIMARY KEY (id) );
