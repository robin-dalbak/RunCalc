CREATE TABLE user
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
    age            INT,
    height         INT,
    weight         INT,
    exercise_level ENUM ('SEDENTARY', 'LIGHTLY_ACTIVE', 'MODERATELY_ACTIVE', 'VERY_ACTIVE', 'SUPER_ACTIVE'),
        FOREIGN KEY (id) REFERENCES user(id)
);

CREATE table calculations
(
    id  BIGINT,
    bmi FLOAT(50),
    bmr FLOAT(50),
    FOREIGN KEY (id) REFERENCES info(id)
);

