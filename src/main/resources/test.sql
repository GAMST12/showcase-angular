

insert into User (usr_login, usr_role, usr_email, usr_password, usr_login_dte)
select	'GAMST', 'U', 'gamst9@gmail.com', 'qwerty', '2017-05-01';


insert into User (usr_login, usr_role, usr_email, usr_password, usr_login_dte)
select	'admin', 'A', 'admin@pbank.com.ua', 'admin', '2017-01-01';


/*
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
select 'Холодильник Samsung A100', 3, 1, 'Высота 2.05. Объем камеры - 190л, морозильной камеры - 90л', 15000.00, 1;
insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'Телевизор Sony C40', 2, 6, 'Диагональ - 40 дюймов, 3D, FullHD', 20000.00, 1;
*/

insert into Main_Category (mnc_mcategory)
select	'Large home appliances';
insert into Main_Category (mnc_mcategory)
select	'Small household appliances';
insert into Main_Category (mnc_mcategory)
select	'TVs and Home cinema';
insert into Main_Category (mnc_mcategory)
select	'Telephones';
insert into Main_Category (mnc_mcategory)
select	'Computers and Accessories';
insert into Main_Category (mnc_mcategory)
select	'Accessories';





insert into Category (ctg_category, ctg_mcategory_id)
select	'Refrigerators', 1;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Washing machines', 1;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Water heaters', 1;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Vacuum cleaners', 2;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Electric kettles', 2;
insert into Category (ctg_category, ctg_mcategory_id)
select	'TVs', 3;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Home cinema', 3;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Smartphones', 4;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Telephones', 4;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Notebooks', 5;
insert into Category (ctg_category, ctg_mcategory_id)
select	'PCs', 5;
insert into Category (ctg_category, ctg_mcategory_id)
select	'Headphones', 6;
insert into Category (ctg_category, ctg_mcategory_id)
select	'USB-storage devices', 5;

insert into Producer (pdc_producer)
select	'LG';
insert into Producer (pdc_producer)
select	'Sony';
insert into Producer (pdc_producer)
select	'Samsung';
insert into Producer (pdc_producer)
select	'Electrolux';
insert into Producer (pdc_producer)
select	'Xiaomi';



insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'Refrigerator Samsung A100', 3, 1, 'Height 2.05. V - 190l/90l', 15000.00, 1;
insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'TV Sony C40', 2, 6, '40, 3D, FullHD', 20000.00, 1;
insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'TV Samsung C32', 3, 6, '32, 3D, FullHD', 12000.00, 1;
insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'Home Cinema Samsung ABC', 3, 6, '54, 3D, FullHD', 120000.00, 1;
insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'Washing machines Electrolux WC80', 4, 2, '6 kg, 1000', 8000.00, 0;
insert into Product (prd_name, prd_producer_id, prd_category_id, prd_description, prd_price, prd_fl_availability)
select 'Smartphone Xiaomi Redmi Note 3 Pro', 5, 8, '5.5, 3 Gb RAM, 32 Gb, FullHD', 5500.00, 0;


