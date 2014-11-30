CREATE TABLE cards
(
  id bigint PRIMARY KEY NOT NULL,
  card_num varchar (16) NOT NULL,
  balance numeric (15,2) NOT NULL,
  blocked bit(1) NOT NULL,
  pin varchar (4) NOT NULL
);
ALTER TABLE cards ADD CONSTRAINT unique_card_id UNIQUE (card_num);