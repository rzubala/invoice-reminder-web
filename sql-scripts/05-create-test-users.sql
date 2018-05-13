USE `payment_reminder_db`;

INSERT INTO `users` 
VALUES ('rafal','{bcrypt}$2a$04$f7IfDXqu7b2fCNHPLkYg5ee4PqanemZas3h.YoaecZzaUc8fVzJoa',1);

INSERT INTO `authorities` 
VALUES 
('rafal','ROLE_USER');
