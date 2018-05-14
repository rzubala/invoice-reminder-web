USE `payment_reminder_db`;

delete from `payment`;
insert into `payment` (`name`, `description`, `date`, `user_id`) VALUES ('name1', 'description1', '2018-05-14', 1);
insert into `payment` (`name`, `description`, `date`, `user_id`) VALUES ('name2', 'description2', '2018-05-15', 1);
insert into `payment` (`name`, `description`, `date`, `user_id`) VALUES ('name3', 'description3', '2018-05-16', 1);
