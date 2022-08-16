CREATE SEQUENCE hibernate_sequence
START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS `product` (
                        `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `name` VARCHAR(255) NOT NULL,
                        `description` VARCHAR(255) NOT NULL,
                        `kcal` int NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `list` (
                        `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `name` VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `product2list` (
                        `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `list_id` BIGINT NOT NULL,
                        `product_id` BIGINT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;