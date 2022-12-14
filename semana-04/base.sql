CREATE DATABASE IF NOT EXISTS `funeraria_bellakoza`;

USE `funeraria_bellakoza`;

DROP TABLE IF EXISTS `moridos`;

CREATE TABLE `moridos` (
    `id` INT(11) AUTO_INCREMENT,
    `nombre` VARCHAR(45) DEFAULT NULL,
    `apellidos` VARCHAR(45) DEFAULT NULL,
    `edad` INT(3) DEFAULT 0,
    `fecha_moricion` VARCHAR(45) DEFAULT NULL,
    `hora_moricion` VARCHAR(45) DEFAULT NULL,
    `lugar_moricion` VARCHAR(45) DEFAULT NULL,
    `causa_moricion` VARCHAR(45) DEFAULT 'natural',
    PRIMARY KEY(`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = latin1;

INSERT INTO
    `moridos`
VALUES
    (
        1,
        'David',
        'Adams',
        63,
        '2001-12-12',
        '12:30 AM',
        'su casita del maincra',
        'lo balaciaron los municipales'
    ),
    (
        2,
        'Samuel',
        'Cornelio',
        24,
        '2073-04-21',
        '04:23 PM',
        'en las miches',
        'lo asalto el bryan'
    ),
    (
        3,
        'La llamada',
        'Del google meet',
        63,
        '2001-12-13',
        '06:03 PM',
        'en el gugle meet',
        'gugle nos cobro'
    ),
    (
        4,
        'Moises',
        'Vidal',
        63,
        '2023-12-12',
        '12:33 AM',
        'en la cerveceria',
        'lo levanrtaron por escuchar corrios tumbaos'
    ),
    (
        5,
        'Emmanuel',
        'Reyes',
        63,
        '2001-02-15',
        '14:32 AM',
        'En el lolsito',
        'no uso a garen xD'
    );