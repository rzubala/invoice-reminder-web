USE `payment_reminder_db`;

ALTER TABLE `payment` add column `amount` double DEFAULT NULL; 
ALTER TABLE `payment` add column `currency` varchar(10) DEFAULT NULL;
ALTER TABLE `payment` add column `paid` boolean DEFAULT NULL;
ALTER TABLE `payment` add column `external_id` int(11) DEFAULT NULL;