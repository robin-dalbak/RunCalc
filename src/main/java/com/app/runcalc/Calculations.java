package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn
public class Calculations extends Info {

    @Id
    private int id;
    private float bmi;
    private float bmr;
    float preBMR;
//    @Column(name = "info_id")
//    private Integer infoId;

    public void CalculateBMI() {
        bmi = (100 * 100 * getWeight() / (getHeight() * getHeight()));
        setBmi(bmi);
    }

    public void CalculateBMR() {

        if (getUserGender().equals(UserGender.MALE)) {
            preBMR = (66.47f + (getWeight() * 13.7f) + (getHeight() * 5f) - (getAge() * 6.8f));
        }
        if (getUserGender().equals(UserGender.FEMALE)) {
            preBMR = (655 + (getWeight() * 9.6f) + (getHeight() * 1.8f) - (getAge() * 4.7f));
        }

        switch (getExerciseLevel()) {
            case SEDENTARY:
                bmr = (preBMR * 1.2f);
                break;
            case LIGHTLY_ACTIVE:
                bmr = (preBMR * 1.375f);
                break;
            case MODERATELY_ACTIVE:
                bmr = (preBMR * 1.5f);
                break;
            case VERY_ACTIVE:
                bmr = (preBMR * 1.725f);
                break;
            case SUPER_ACTIVE:
                bmr = (preBMR * 1.9f);
                break;

        } setBmr(bmr);

    }

    public Calculations() {
    }


    public Calculations(String firstName, String lastName, String password, String email, UserGender userGender, int age, float height, float weight, ExerciseLevel exerciseLevel, float bmi, float bmr) {
        super(firstName, lastName, password, email, userGender, age, height, weight, exerciseLevel);
        this.bmi = bmi;
        this.bmr = bmr;
//        this.infoId = infoId;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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

//    public Integer getInfoId() {
//        return infoId;
//    }
//
//    public void setInfoId(Integer infoId) {
//        this.infoId = infoId;
//    }

}


