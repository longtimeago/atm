DROP TABLE test.operations;
DROP TABLE test.cards;

CREATE TABLE test.cards
(
  id bigint PRIMARY KEY NOT NULL,
  card_num varchar (16) NOT NULL,
  balance numeric (15,2) NOT NULL,
  blocked bit(1) NOT NULL,
  pin varchar (4) NOT NULL
);
ALTER TABLE test.cards ADD CONSTRAINT unique_card_id UNIQUE (card_num);

CREATE TABLE operations
(
  id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  card_id bigint NOT NULL,
  dtm TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  amount DECIMAL(15,2) NOT NULL,
  oper_code varchar(1) NOT NULL,

  FOREIGN KEY (card_id)
  REFERENCES cards(id)
    ON DELETE CASCADE
);
