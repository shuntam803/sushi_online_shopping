# すでにproductテーブルが存在していれば削除する
# DROP TABLE product if EXISTS;

# productテーブルの作成
CREATE TABLE product (
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	price INT NOT NULL);

# 17件の商品レコード追加
INSERT INTO product
(id, NAME, price)
	VALUES
	(1, 'まぐろ', 100),
	(2, 'サーモン', 100),
	(3, 'えび', 100),
	(4, 'いか', 100),
	(5, 'えんがわ', 100),
	(6, 'あなご', 100),
	(7, 'たまご', 100),
	(8, 'ほたて', 100),
	(9, '赤貝', 100),
	(10, 'つぶ貝', 100),
	(11, 'サラダ軍艦', 150),
	(12, 'ねぎとろ軍艦', 150),
	(13, 'ねぎとろ巻き', 150),
	(14, 'アボカド巻き', 150),
	(15, 'トロ', 200),
	(16, 'いくら', 200),
	(17, 'うに', 200);