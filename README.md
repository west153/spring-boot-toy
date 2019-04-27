# spring-boot-toy

swagger
http://localhost:8080/swagger-ui.html

#### mysql 5.7 

create database spring_boot_toy DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; #디비 생성

create user 'spring_boot_toy_admin'@'localhost' identified by 'spring_boot_toy_pw1'; #유저 생성

GRANT ALL PRIVILEGES ON spring_boot_toy.* TO 'spring_boot_toy_admin'@'localhost' identified by 'spring_boot_toy_pw1';#권한 설정