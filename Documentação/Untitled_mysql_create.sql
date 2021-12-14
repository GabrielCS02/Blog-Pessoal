CREATE TABLE `tb_temas` (
	`Música` varchar(255) NOT NULL,
	`id` INT(255) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_bandas` (
	`Bandas preferidas` varchar(255) NOT NULL,
	`Quantidade de shows` INT(50) NOT NULL,
	`Musica de maior sucesso` varchar(255) NOT NULL,
	`Data de formação` DATE(255) NOT NULL,
	`id_banda` INT(255) NOT NULL
);

CREATE TABLE `tb_sobre_banda` (
	`Instrumentos utilizados` varchar(255) NOT NULL,
	`Tipo musical` varchar(255) NOT NULL,
	`Integrantes` varchar(255) NOT NULL,
	`Shows` BOOLEAN(255) NOT NULL,
	`id_sobre_banda` BOOLEAN(255) NOT NULL
);

ALTER TABLE `tb_bandas` ADD CONSTRAINT `tb_bandas_fk0` FOREIGN KEY (`id_banda`) REFERENCES `tb_temas`(`id`);

ALTER TABLE `tb_sobre_banda` ADD CONSTRAINT `tb_sobre_banda_fk0` FOREIGN KEY (`id_sobre_banda`) REFERENCES `tb_bandas`(`id_banda`);




