-- Bank (1)
-- Customer (N)
------------------------TABLE BANK------------------------------------------------------
-- CREATE Bank (1)
CREATE TABLE IF NOT EXISTS bank(
    bank_id serial NOT NULL,
	bank_name character varying DEFAULT 'banka ad�n� girmediniz' UNIQUE,
	branch_name  character varying  DEFAULT '�ube ad�n� girmediniz',
	created_date TIMESTAMP WITH TIME ZONE default  CURRENT_TIMESTAMP,
	PRIMARY KEY (bank_id)
)

------------------------TABLE CUSTOMER------------------------------------------------------
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

------------------------DDL DML------------------------------------------------------
-- DROP DATABASE
drop database turkcell_db;

-- DROP TABLE ilk �nce 
drop table customer;
drop table bank;

--TRUNCATE TABLE
truncate table customer restart identity

-- INSERT TABLE ilk �nce 
insert into  bank (bank_name,branch_name) values ('banka xyz','banka �ubesi 452');
insert into  customer (customer_name,customer_surname,customer_identity,bank_id) values ('m��teri ad�','m��teri soyad�','1245155',1);

------------------------INDEX------------------------------------------------------
-- s�rekli sorgu att���m�z tablodaki sutun i�in kullan�yoruz.
CREATE INDEX customer_name_index on  customer(customer_name);


------------------------FUNCTION------------------------------------------------------


------------------------INNER JOIN------------------------------------------------------
select * from bank as b1 inner join customer as c1 on b1.bank_id=c1.bank_id;


------------------------VIEW------------------------------------------------------
--CREATE VIEW
CREATE VIEW customer_inner_join
AS
select * from bank
select * from bank  inner join customer on bank.bank_id=customer.bank_id

--DROP VIEW
drop view customer_inner_join


