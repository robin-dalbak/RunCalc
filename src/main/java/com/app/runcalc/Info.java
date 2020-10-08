package com.app.runcalc;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

public class Info extends User {

    @Id
    int id;
    @Enumerated(EnumType.STRING)
    String userGender;
    int age;
    float height;
    float weight;
    @Enumerated(EnumType.STRING)
    int exerciseLevel;

    public Info() {
    }



    public Info(String firstName, String lastName, String password, String email, String userGender, int age, float height, float weight, int exerciseLevel) {
        super(firstName, lastName, password, email);
        this.userGender = userGender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.exerciseLevel = exerciseLevel;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getExerciseLevel() {
        return exerciseLevel;
    }

    public void setExerciseLevel(int exerciseLevel) {
        this.exerciseLevel = exerciseLevel;
    }


}
