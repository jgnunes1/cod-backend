-- Script para criar o banco e o usuário localmente
-- Use: sudo mysql < create_mysql_user.sql  ou mysql -u root -p < create_mysql_user.sql

CREATE DATABASE IF NOT EXISTS `billing_app`
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'billing'@'localhost' IDENTIFIED BY 'qwe123';
GRANT ALL PRIVILEGES ON `billing_app`.* TO 'billing'@'localhost';
FLUSH PRIVILEGES;

-- Opcional: mostrar bancos e privilégios
SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'billing_app';
SHOW GRANTS FOR 'billing'@'localhost';
