CREATE DATABASE IF NOT EXISTS `web_shop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `web_shop`;

CREATE TABLE `products` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) DEFAULT NULL,
    `description` VARCHAR(120) DEFAULT NULL,
    `content` VARCHAR(45) DEFAULT NULL,
    `price` VARCHAR(45) DEFAULT NULL,
    `date_register` DATE DEFAULT NULL,
    `date_expiration` DATE DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = latin1;

/*INSERT VALUES IN TABLE products*/
INSERT INTO `products` 
    (name, description, content, price, date_register, date_expiration)
    VALUES 
    ('Chetos','flaming hot','50g','$5.00','2008-7-04','2008-7-04'),
    ('computadora','HP pavillion','1pza','$17,000.00','2008-7-04','2008-7-04'),
    ('Café','nescafe molido','300g','$80.00','2008-7-04','2008-7-04'),
    ('pantalon', 'sahara mezclilla','50g','$5.00','2008-7-04','2008-7-04'),
    ('guitarra','fender acustica','50g','$5.00','2008-7-04','2008-7-04'),
    ('Zucaritas','Cerial xD', '250gr.', '50.0', '2022-12-08', '2022-12-22'), 
	('Takis', 'Taquitos picantes con chile del que si pica xD', '67gr.', '15', '2022-12-08', '2023-01-21');
