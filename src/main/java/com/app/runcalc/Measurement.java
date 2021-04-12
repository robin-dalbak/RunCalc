package com.app.runcalc;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.math.BigInteger;
import java.util.Date;


@Entity
@PrimaryKeyJoinColumn
@Inheritance(strategy = InheritanceType.JOINED)
public class Measurement extends User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @JoinColumn(name="user_id")
    private int userId;

    @Column(name = "date_measurement")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateMeasurement;
    private float height;
    private float weight;
    @Enumerated(EnumType.STRING)
    @Column(name = "exercise_level")
    private ExerciseLevel exerciseLevel;
    private float bmi;
    private float bmr;

    public void CalculateBMI() {
        bmi = (100 * 100 * getWeight() / (getHeight() * getHeight()));
        setBmi(Math.round(bmi));
    }

//    public void CalculateBMR() {
//        float preBMR = 0;
//
//        if (getUserGender().equals(UserGender.MALE)) {
//            preBMR = (66.47f + (getWeight() * 13.7f) + (getHeight() * 5f) - (getAge() * 6.8f));
//        }
//        if (getUserGender().equals(UserGender.FEMALE)) {
//            preBMR = (655 + (getWeight() * 9.6f) + (getHeight() * 1.8f) - (getAge() * 4.7f));
//        }
//
//        switch (getExerciseLevel()) {
//            case SEDENTARY:
//                bmr = (preBMR * 1.2f);
//                break;
//            case LIGHTLY_ACTIVE:
//                bmr = (preBMR * 1.375f);
//                break;
//            case MODERATELY_ACTIVE:
//                bmr = (preBMR * 1.5f);
//                break;
//            case VERY_ACTIVE:
//                bmr = (preBMR * 1.725f);
//                break;
//            case SUPER_ACTIVE:
//                bmr = (preBMR * 1.9f);
//                break;
//
//        } setBmr(bmr);
//
//    }




    public Measurement() {
    }

    public Measurement(int userId, Date dateMeasurement, float height, float weight, ExerciseLevel exerciseLevel, float bmi, float bmr) {
        this.userId = userId;
        this.dateMeasurement = dateMeasurement;
        this.height = height;
        this.weight = weight;
        this.exerciseLevel = exerciseLevel;
        this.bmi = bmi;
        this.bmr = bmr;
    }




    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateMeasurement() {
        return dateMeasurement;
    }

    public void setDateMeasurement(Date dateMeasurement) {
        this.dateMeasurement = dateMeasurement;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ExerciseLevel getExerciseLevel() {
        return exerciseLevel;
    }

    public void setExerciseLevel(ExerciseLevel exerciseLevel) {
        this.exerciseLevel = exerciseLevel;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getBmr() {
        return bmr;
    }

    public void setBmr(float bmr) {
        this.bmr = bmr;
    }



}

