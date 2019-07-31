CREATE TABLE item (
  id bigint(20) NOT NULL ,--AUTO_INCREMENT,
  item_code INT DEFAULT 0,
  item_name varchar(255) DEFAULT NULL,
   inventory_code varchar(100) DEFAULT NULL,
  quantity INT DEFAULT 0,
  PRIMARY KEY (id)
);
