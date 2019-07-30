CREATE DATABASE colapp;

CREATE USER 'colapp'@'localhost' IDENTIFIED BY 'secreto';

GRANT ALL ON colapp.* TO 'colapp'@'localhost';



