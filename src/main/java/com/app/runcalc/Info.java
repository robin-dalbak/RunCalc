package com.app.runcalc;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

@Entity
@PrimaryKeyJoinColumn
@Inheritance(strategy = InheritanceType.JOINED)
public class Info extends User {

    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private UserGender userGender;

    @Column(name="age")
    @Positive
    @Max(value = 120)
    private Integer age;

    private float height;
    private float weight;
    @Enumerated(EnumType.STRING)
    @Column(name = "exercise_level")
    private ExerciseLevel exerciseLevel;
//    @Column(name = "user_id")
//    private Integer userId;

    public Info() {
    }

    public Info(String firstName, String lastName, String password, String email, UserGender userGender, Integer age, float height, float weight, ExerciseLevel exerciseLevel) {
        super(firstName, lastName, password, email);
        this.userGender = userGender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.exerciseLevel = exerciseLevel;
//        this.userId = userId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    public UserGender getUserGender() {
        return userGender;
    }

    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public ExerciseLevel getExerciseLevel() {
        return exerciseLevel;
    }

    public void setExerciseLevel(ExerciseLevel  exerciseLevel) {
        this.exerciseLevel = exerciseLevel;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//    this.userId = userId;
//    }

}
