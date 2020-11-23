INSERT INTO user (first_name, last_name, gender, birth_date, user_img, bio, want_newsletter, email, password)
VALUES ('Abdi', 'Mohamed', 'MALE', '1992-01-01', 'src/main/resources/static/userimg/Abdi_Mohamed.jpg', 'Love all kind of sports', true, 'Abdi123@gmail.com', '12345'),
       ('Ola', 'Nordmann', 'MALE', '1980-04-25', 'src/main/resources/static/userimg/Ola_Nordmann.jpg', 'Running five times a week', false, 'Ola123@gmail.com', '123456'),
       ('Kari', 'Madsen', 'FEMALE', '1993-07-08','src/main/resources/static/userimg/Kari_Madsen.jpg', 'Not so active, but do all kind of sports now and then', false, 'Kari123@gmail.com', '123456'),
       ('Christer', 'Falck', 'MALE', '1975-04-12', 'src/main/resources/static/userimg/Christer_Falck.jpg', 'Just started running', true, 'Christer123@gmail.com', '123456'),
       ('Sonja', 'Agnes', 'FEMALE', '1966-12-24', 'src/main/resources/static/userimg/Sonja_Agnes.jpg', 'Preparing for marathon number 1000', false, 'Sonja123@gmail.com', '123456'),
       ('Kristine', 'Jensen', 'FEMALE', '1989-02-04', 'src/main/resources/static/userimg/Kristine_Jensen.jpg', 'Obsessed with training applications and triathlons', true, 'Kristine123@gmail.com', '123456');

INSERT INTO measurement (user_id, date_measurement, height, weight, exercise_level, bmi, bmr)
VALUES (1, '2020-11-16 18:38:40', 184, 78, 'SUPER_ACTIVE', '', ''),
       (2, '2020-11-16 18:38:41', 160, 100, 'SEDENTARY', '', ''),
       (3, '2020-11-16 18:38:42', 152, 48, 'VERY_ACTIVE', '', ''),
       (4, '2020-11-16 18:38:43', 189, 98, 'MODERATELY_ACTIVE', '', ''),
       (5, '2020-11-16 18:38:44', 159, 61, 'LIGHTLY_ACTIVE', '', ''),
       (6, '2020-11-16 18:38:45', 164, 62, 'SEDENTARY', '', '');

-- INSERT INTO workout(user_id, name_of_workout, type_of_workout, image_of_workout, description, time_spent, route)
-- VALUES (1, '', '', '', '', '', ''),
--        (2, '', '', '', '', '', ''),
--        (3, '', '', '', '', '', ''),
--        (4, '', '', '', '', '', ''),
--        (5, '', '', '', '', '', ''),
--        (6, '', '', '', '', '', '');

