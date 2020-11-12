select *
from info
join user 
on info.id = user.id
join calculations
on info.id = calculations.id;

select *
from info
join user
on info.id = user.id;

create schema try;
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
    age            INT(2),
    height         INT(3),
    weight         INT(3),
    exercise_level ENUM ('SEDENTARY', 'LIGHTLY_ACTIVE', 'MODERATELY_ACTIVE', 'VERY_ACTIVE', 'SUPER_ACTIVE'),
    user_id        BIGINT,
        FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE table calculations
(
    id  BIGINT,
    bmi FLOAT(50),
    bmr FLOAT(50),
    info_id BIGINT,
    FOREIGN KEY (info_id) REFERENCES user(id)
);

select * from user;



INSERT INTO user (first_name, last_name, password, email)
VALUES ('Abdi', 'Mohamed', '123456', 'Abdi123@gmail.com'),
       ('Ola', 'Nordmann', '123456', 'Ola123@gmail.com'),
       ('Kari', 'Madsen', '123456', 'Kari123@gmail.com'),
       ('Christer', 'Falck', '123456', 'Christer123@gmail.com'),
       ('Sonja', 'Agnes', '123456', 'Sonja123@gmail.com'),
       ('Kristine', 'Jensen', '123456', 'Kristine123@gmail.com');

INSERT INTO info (id, user_gender, age, height, weight, exercise_level, user_id)
VALUES (1, 'MALE', 18, 184, 78, 'SUPER_ACTIVE', 1),
       (2, 'MALE', 38, 160, 100, 'SEDENTARY', 2),
       (3, 'FEMALE', 22, 152, 48, 'VERY_ACTIVE', 3),
       (4, 'MALE', 51, 189, 98, 'MODERATELY_ACTIVE', 4),
       (5, 'FEMALE', 34, 159, 61, 'LIGHTLY_ACTIVE', 5),
       (6, 'FEMALE', 44, 164, 62, 'SEDENTARY', 6);

INSERT INTO calculations(id, bmi, bmr, info_id)
VALUES (1, 51, 21, 1),
       (2, 51, 21, 2),
       (3, 51, 21, 3),
       (4, 51, 21, 4),
       (5, 51, 21, 5),
       (6, 51, 21, 6);


 @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, @ModelAttribute Info info, @ModelAttribute Calculations calculations, HttpSession s, Model m) {
        User logger = userRepository.findByEmail(user.getEmail());
        Info userInfo = infoRepository.findByEmail(info.getEmail());
        Calculations userCalculations = calculationsRepository.findByEmail(calculations.getEmail());


https://www.polar.com/blog/wp-content/uploads/2020/02/What-is-mindful-running-main.jpg


CREATE TABLE user
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name      VARCHAR(20),
    last_name       VARCHAR(30),
    user_gender     ENUM ('Male', 'FEMALE'),
    birth_date      DATE,
    user_img        VARCHAR(100),
    BIO             VARCHAR(500),
    want_newsletter BOOLEAN,
    email           VARCHAR(50),
    password        VARCHAR(50)
);

CREATE TABLE measurement
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT,
    date_measurement DATETIME,
    height           INT,
    weight           INT,
    exercise_level   ENUM ('SEDENTARY', 'LIGHTLY_ACTIVE', 'MODERATELY_ACTIVE', 'VERY_ACTIVE', 'SUPER_ACTIVE'),
    bmi              float(50),
    bmr              float(50),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE table workout
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT,
    name_of_workout  VARCHAR(50),
    type_of_workout  ENUM ('RUN', 'CYCLE', 'SWIM'),
    image_of_workout VARCHAR(100),
    description      VARCHAR(500),
    time_spent       TIME,
    route            VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

alter table user
add measurement_id BIGINT;
alter table user
add foreign key (measurement_id) references measurement (id);
alter table user
add workout_id BIGINT;
alter table user
add foreign key (workout_id) references workout (id);