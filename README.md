Målet for oppgaven er å lage en løsning som gir deg ulike resultater som kan bli brukt for å komme i form, samt nå sine fysiske mål.
Tjenesten har ulike kalkulatorer som skal hjelpe til med det, deriblant BMI og BMR. Det er også blitt laget kode for å regne ut hvilken 
hastighet man må holde for å løpe et gitt antall kilometer.

Den er satt opp slik at man må lage seg en bruker og plotte inn ulike data om deg selv, så vil den da gi deg BMI og BMR.
Inne på tjenesten er skal også hastighetskalkulatoren være.

Det har blitt tatt i bruk 3 ulike tabeller, 1 for brukere, 1 for dataen til brukerne og 1 til BMI/BMR resultater.

Teknologier som er tatt i bruk er Java, Spring, Thymeleaf, MYSQL, H2, HTML og CSS.

Tjenesten er per dags dato ikke ferdig da jeg sliter med å sette tabellene sammen ved hjelp av Spring.

Skrevet 08.10.2020 21:57


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