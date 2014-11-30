CREATE TABLE operations
(
  id bigint auto_increment primary key,
  card_id bigint NOT NULL,
  dtm TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  amount DECIMAL(15,2) NOT NULL,
  oper_code varchar(1) NOT NULL,
  FOREIGN KEY (card_id) REFERENCES cards(id) ON DELETE CASCADE
);