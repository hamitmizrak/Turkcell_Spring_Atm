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

-- CREATE Bank (1)
CREATE TABLE IF NOT EXISTS bank(
    bank_id serial NOT NULL,
	bank_name character varying default 'bank_name',
	branch_name  character varying,
	created_date TIMESTAMP WITH TIME ZONE default  CURRENT_TIMESTAMP,
	PRIMARY KEY (bank_id)
)

drop table bank;


-- CREATE Customer (N)
CREATE TABLE IF NOT EXISTS customer(
   customer_id serial NOT NULL,
	customer_name character varying,
	customer_surname character varying,
	customer_identity character varying,
	bank_id INT NOT NULL references bank(bank_id),
	created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (customer_id)
)
    