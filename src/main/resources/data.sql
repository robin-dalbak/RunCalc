INSERT INTO user (first_name, last_name, password, email)
VALUES ('Abdi', 'Mohamed', '123456', 'Abdi123@gmail.com'),
       ('Ola', 'Nordmann', '123456', 'Ola123@gmail.com'),
       ('Kari', 'Madsen', '123456', 'Kari123@gmail.com'),
       ('Christer', 'Falck', '123456', 'Christer123@gmail.com'),
       ('Sonja', 'Agnes', '123456', 'Sonja123@gmail.com'),
       ('Kristine', 'Jensen', '123456', 'Kristine123@gmail.com');

INSERT INTO info (id, user_gender, age, height, weight, exercise_level)
VALUES (1, 'MALE', 18, 184, 78, 'SUPER_ACTIVE'),
       (2, 'MALE', 38, 160, 100, 'SEDENTARY'),
       (3, 'FEMALE', 22, 152, 48, 'VERY_ACTIVE'),
       (4, 'MALE', 51, 189, 98, 'MODERATELY_ACTIVE'),
       (5, 'FEMALE', 34, 159, 61, 'LIGHTLY_ACTIVE'),
       (6, 'FEMALE', 44, 164, 62, 'SEDENTARY');

INSERT INTO calculations(id, bmi, bmr)
VALUES (1, 51, 21),
       (2, 51, 21),
       (3, 51, 21),
       (4, 51, 21),
       (5, 51, 21),
       (6, 51, 21);

