package com.app.runcalc;


import javax.persistence.*;
import java.sql.Time;

@Entity
@PrimaryKeyJoinColumn
public class Workout extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;
    @Column(name = "name_of_workout")
    private String nameOfWorkout;
    @Column(name = "type_of_workout")
    private TypeOfWorkout typeOfWorkout;
    @Column(name = "image_of_workout")
    private String imageOfWorkout;
    private String description;
    @Column(name = "time_spent")
    private Time timeSpent;
    private String route;


    public Workout() {
    }


    public Workout(User userId, String nameOfWorkout, TypeOfWorkout typeOfWorkout, String imageOfWorkout, String description, Time timeSpent, String route) {
        super();
        this.userId = userId;
        this.nameOfWorkout = nameOfWorkout;
        this.typeOfWorkout = typeOfWorkout;
        this.imageOfWorkout = imageOfWorkout;
        this.description = description;
        this.timeSpent = timeSpent;
        this.route = route;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getNameOfWorkout() {
        return nameOfWorkout;
    }

    public void setNameOfWorkout(String nameOfWorkout) {
        this.nameOfWorkout = nameOfWorkout;
    }

    public TypeOfWorkout getTypeOfWorkout() {
        return typeOfWorkout;
    }

    public void setTypeOfWorkout(TypeOfWorkout typeOfWorkout) {
        this.typeOfWorkout = typeOfWorkout;
    }

    public String getImageOfWorkout() {
        return imageOfWorkout;
    }

    public void setImageOfWorkout(String imageOfWorkout) {
        this.imageOfWorkout = imageOfWorkout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Time timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }


}


