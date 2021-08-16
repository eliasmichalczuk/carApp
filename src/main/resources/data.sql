
CREATE TABLE veiculo (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marca varchar(255),
    ano integer,
    descricao text,
    vendido bit,
    created timestamp,
    updated timestamp
);