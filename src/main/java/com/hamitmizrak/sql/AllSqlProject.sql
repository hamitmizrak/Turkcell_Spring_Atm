-----------------DATABASE----------------------------------    
--CREATA DATABASE
CREATE DATABASE turkcell_db
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
-----------------TABLE----------------------------------    
-- Bank (1)
-- Customer (N)

    -- Bank (1)
-- Customer (N)

-- CREATE Bank (1)
CREATE TABLE IF NOT EXISTS bank(
    bank_id serial NOT NULL,
	bank_name character varying DEFAULT 'banka ad�n� girmediniz' UNIQUE,
	branch_name  character varying  DEFAULT '�ube ad�n� girmediniz',
	created_date TIMESTAMP WITH TIME ZONE default  CURRENT_TIMESTAMP,
	PRIMARY KEY (bank_id)
)


-- CREATE Customer (N)
CREATE TABLE IF NOT EXISTS customer(
    customer_id serial NOT NULL,
	customer_name character varying,
	customer_surname character varying,
	customer_identity character varying(44) UNIQUE,
	bank_id INT NOT NULL references bank(bank_id),
	created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (customer_id)
)

-- Silme ilk �nce 
drop table customer;
drop table bank;


-- Ekleme ilk �nce 
insert into  bank (bank_name,branch_name) values ('banka xyz','banka �ubesi 452');
insert into  customer (customer_name,customer_surname,customer_identity,bank_id) values ('m��teri ad�','m��teri soyad�','1245155',1);

