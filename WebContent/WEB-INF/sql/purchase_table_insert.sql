# すでにpurchaseテーブルが存在していれば削除する
# DROP TABLE purchase if EXISTS;

# purchaseテーブルの作成
CREATE TABLE purchase (
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_id INT NOT NULL,
	product_name VARCHAR(100) NOT NULL,
	product_price INT NOT NULL,
	product_count INT NOT NULL,
	customer_name VARCHAR(100) NOT NULL,
	customer_address VARCHAR(100) NOT NULL
);