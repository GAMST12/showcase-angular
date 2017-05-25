
DROP TABLE IF EXISTS Main_Category;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Producer;
DROP TABLE IF EXISTS Product;




CREATE TABLE IF NOT EXISTS Main_Category (
	mnc_mcategory_id INT NOT NULL AUTO_INCREMENT,
	mnc_mcategory VARCHAR(128) NOT NULL,
  	PRIMARY KEY (mnc_mcategory_id),
    UNIQUE UQ_MNC_CATEGORY (mnc_mcategory)
);

CREATE TABLE IF NOT EXISTS Category (
	ctg_category_id INT NOT NULL AUTO_INCREMENT,
	ctg_category VARCHAR(256) NOT NULL,
	ctg_mcategory_id INT NOT NULL,
	  PRIMARY KEY (ctg_category_id),
	  UNIQUE UQ_CTG_CATEGORY (ctg_category),
	  CONSTRAINT FK_CATEGORY_MAIN_CATEGORY FOREIGN KEY (ctg_mcategory_id) REFERENCES Main_Category(mnc_mcategory_id)
);

CREATE TABLE IF NOT EXISTS Producer (
	pdc_producer_id INT NOT NULL AUTO_INCREMENT,
	pdc_producer VARCHAR(128) NOT NULL,
	  PRIMARY KEY (pdc_producer_id),
	  UNIQUE UQ_PDC_PRODUCER (pdc_producer)
);


CREATE TABLE IF NOT EXISTS Product (
	prd_product_id INT NOT NULL AUTO_INCREMENT,
  prd_name VARCHAR(128) NOT NULL,
  prd_producer_id INT NOT NULL,
  prd_category_id  INT NOT NULL,
  prd_description VARCHAR(1024) NOT NULL,
  prd_price NUMERIC(15,2) NOT NULL DEFAULT 0.0,
  prd_fl_availability BIT(1) NOT NULL DEFAULT 0,
	  PRIMARY KEY (prd_product_id),
    CONSTRAINT FK_PRODUCT_PRODUCER FOREIGN KEY (prd_producer_id) REFERENCES Producer(pdc_producer_id),
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (prd_category_id) REFERENCES Category(ctg_category_id)
);
