CREATE USER 'recruiter' @'localhost' IDENTIFIED BY 'recruiter';

GRANT ALL PRIVILEGES ON *.* TO 'recruiter' @'localhost';
s
CREATE DATABASE IF NOT EXISTS `web_candidates`;

USE `web_candidates`;

DROP TABLE IF EXISTS `candidates`;

CREATE TABLE `candidates` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    `phone` VARCHAR(10) DEFAULT NULL,
    `department` VARCHAR(45) DEFAULT NULL,
    `degree` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `candidates` VALUES (1, 'Mery', 'Jane', 'meryjein@mail.com', '1234567890', 'Human Resources', 'psychologist'), 
								(2, 'Piter', 'Parker', 'spaiderman@mail.com', '1234567890', 'Daily news', 'Photographer'), 
								(3, 'Clark', 'Kent', 'superman@mail.com', '1234567890', 'Daily Planet', 'Reporter'), 
								(4, 'Matt', 'Murdock', 'ddevil@mail.com', '1234567890', 'Legales', 'Lawyer'); 