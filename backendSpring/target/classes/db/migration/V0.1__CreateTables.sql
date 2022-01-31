set foreign_key_checks=0;

CREATE TABLE users (
    id INT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    endereco_id INT(20) UNSIGNED NOT NULL,
    cep VARCHAR (8) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,

    CONSTRAINT FK_endereco_id FOREIGN KEY (endereco_id) REFERENCES address(id)

);

CREATE TABLE address(
    id INT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero INT(11) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade_id INT(20) UNSIGNED NOT NULL,
    estado_id INT(20) UNSIGNED NOT NULL,

    CONSTRAINT FK_cidade FOREIGN KEY (cidade_id) REFERENCES cities(id),
    CONSTRAINT FK_estado FOREIGN KEY (estado_id) REFERENCES states(id)
);

CREATE TABLE cities (
    id INT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cidade VARCHAR(255) NOT NULL
);

CREATE TABLE states (
    id INT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL
);

set foreign_key_checks=1;