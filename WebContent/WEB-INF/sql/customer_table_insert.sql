# すでにcustomerテーブルが存在していれば削除する
# DROP TABLE customer if EXISTS;

# customerテーブルの作成
CREATE TABLE customer (
	id INT AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL);

# 5件の商品レコード追加
INSERT INTO customer
(id, login, password)
	VALUES
	(null, 'aykawa', 'SweetfishRiver1'),
	(null, 'samejima', 'SharkIsland2'),
	(null, 'wanibuchi', 'CrocodileChasm3'),
	(null, 'ebihara', 'ShrimpField4'),
	(null, 'kanie', 'CrubBay5');