USE `payment_reminder_db`;

DROP TABLE IF EXISTS `settings_mail`;
CREATE TABLE `settings_mail` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `login` varchar(45) DEFAULT NULL,
    `password` varchar(225) DEFAULT NULL,
     PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

