DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_key VARCHAR(20) NOT NULL,
  user_name VARCHAR(100) NOT NULL,
  user_gender VARCHAR(20) DEFAULT NULL,
  user_country VARCHAR(100) DEFAULT NULL
);

DROP TABLE IF EXISTS korean;

CREATE TABLE korean (
  korean_id INT NOT NULL,
  korean_key VARCHAR(20) PRIMARY KEY ,
  korean_name VARCHAR(100) NOT NULL,
  korean_pronounce VARCHAR(100) NOT NULL,
  korean_gender VARCHAR(20) DEFAULT NULL
) charset = utf8;