USE `payment_reminder_db`;

delete from `users`;
INSERT INTO `users` 
VALUES (1, 'rafal','{bcrypt}$2a$04$f7IfDXqu7b2fCNHPLkYg5ee4PqanemZas3h.YoaecZzaUc8fVzJoa',1);

delete from `authorities`;
INSERT INTO `authorities` 
VALUES 
('rafal','ROLE_USER');
