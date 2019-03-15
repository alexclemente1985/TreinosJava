create user 'alex_tw_springboot'@'localhost' identified by 'password';
grant all privileges on *.* to 'alex_tw_springboot'@'localhost';
flush privileges;
create schema twspringboot;