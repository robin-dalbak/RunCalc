CREATE TABLE User
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20),
    last_name  VARCHAR(30),
    password   VARCHAR(50),
    email      VARCHAR(50)
);

CREATE TABLE info
(
    id             BIGINT,
    user_gender    ENUM ('MALE', 'FEMALE'),
    age            INT(2),
    height         INT(3),
    weight         INT(3),
    exercise_level ENUM ('1', '2', '3', '4', '5')
    FOREIGN KEY (id) REFERENCES user (id)
);



INSERT INTO User (first_name, last_name, password, email)
VALUES ('Abdi', 'Nordmann', '123456', 'Abdi123@gmail.com');