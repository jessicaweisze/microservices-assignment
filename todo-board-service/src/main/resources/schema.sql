DROP TABLE IF EXISTS 'resolution_item';
CREATE TABLE 'resolution_item' (
  'item_id' int(20) NOT NULL AUTO_INCREMENT,
  'description' varchar(150),
  'status' varchar(50),
  'title' varchar(100),
  'user_id' varchar(50),
  PRIMARY KEY ('item_id')
);