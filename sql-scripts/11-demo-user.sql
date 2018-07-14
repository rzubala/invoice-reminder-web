USE `payment_reminder_db`;

INSERT INTO `users` 
VALUES (2, 'demo','{bcrypt}$2a$04$6r2ncSLbYjvbTMC7sXSovuEb8VbWYLraMt/s4NBKD0YFZS.YiHUzO', 1, null);

INSERT INTO `authorities` 
VALUES 
(2, 2,'ROLE_DEMO');
