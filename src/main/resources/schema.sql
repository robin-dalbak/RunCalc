CREATE TABLE user
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name      VARCHAR(20),
    last_name       VARCHAR(30),
    user_gender     ENUM ('Male', 'FEMALE'),
    birth_date      DATE,
    user_img        VARCHAR(100),
    bio             VARCHAR(500),
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

ALTER TABLE user
    ADD measurement_id BIGINT;
ALTER TABLE user
    ADD FOREIGN KEY (measurement_id) REFERENCES measurement (id);
ALTER TABLE user
    ADD workout_id BIGINT;
ALTER TABLE user
    ADD FOREIGN KEY (workout_id) REFERENCES workout (id);

