USE `payment_reminder_db`;

ALTER TABLE `users` add column `email` varchar(255) DEFAULT NULL;
