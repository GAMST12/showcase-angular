

insert into User (usr_login, usr_role, usr_email, usr_password, usr_login_dte)
select	'GAMST', 'U', 'gamst9@gmail.com', 'qwerty', '2017-05-01';


insert into User (usr_login, usr_role, usr_email, usr_password, usr_login_dte)
select	'admin', 'A', 'admin@pbank.com.ua', 'admin', '2017-01-01';


insert into Main_Category (mnc_mcategory)
select	'Крупная бытовая техника';
insert into Main_Category (mnc_mcategory)
select	'Мелкая бытовая техника';
insert into Main_Category (mnc_mcategory)
select	'Телевизоры';
insert into Main_Category (mnc_mcategory)
select	'Телефоны';
insert into Main_Category (mnc_mcategory)
select	'Компьютеры и комплектующие';
insert into Main_Category (mnc_mcategory)
select	'Аксессуары';





insert into Category (ctg_category, ctg_mcategory_id)
select	'Холодильники', 1;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Стиральные машины', 1;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Водонагреватели', 1;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Пылесосы', 2;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Электрочайники', 2;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Телевизоры', 3;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Домашние кинотеатры', 3;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Смартфоны', 4;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Телефоны', 4;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Ноутбуки', 5;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Компьютеры', 5;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Наушники', 6;
insert into Category (ctg_category, ctg_mcategory_id)
select	'USB-накопители', 5;

insert into Producer (pdc_producer)
select	'LG';
insert into Producer (pdc_producer)
select	'Sony';
insert into Producer (pdc_producer)
select	'Samsung';
insert into Producer (pdc_producer)
select	'Electrolux';


insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'Холодильник Samsung A100', 3, 1, 'Высота 2.05. Объем камеры - 190л, морозильной камеры - 90л', 15000.00, 1

