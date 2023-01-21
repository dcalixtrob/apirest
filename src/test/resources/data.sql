DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
  USERNAME VARCHAR(50) PRIMARY KEY,
  CODIGO VARCHAR(4) NOT NULL,
  TIPO VARCHAR(1) NOT NULL,
  PASSWORD VARCHAR(150) NOT NULL
);

insert into user (USERNAME, CODIGO, TIPO, PASSWORD) values ('usrdocente', 'D001', 'D', '$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK');
insert into user (USERNAME, CODIGO, TIPO, PASSWORD) values ('usralumno', 'A001', 'A', '$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK');
