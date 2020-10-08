package com.app.runcalc;

import java.util.Scanner;

public class Formulas {


    public float timeInSeconds;
    float timeInMinutes;
    float distanceInKilometer;
    float kilometerPerHour;
    float metersPerSecond;
    float minutesPerKilometer;
    int intMinutesPerKilometer;
    float secondsPerKilometer;
    float bodyMassIndex;
    float preBMR;
    float basalMetabolicRate;
    double squareRootHeight;
    float minPerKm;
    int paceMinute;
    float paceSecond;
    float pace;


    Scanner input = new Scanner(System.in);

    public void CalculateBMI() {
        System.out.println("What is your weight?");
        float weight = input.nextFloat();
        System.out.println("What is your height in cm?");
        float height = input.nextFloat();

        bodyMassIndex = (100 * 100 * weight) / (height * height);
        System.out.println("Your BMI is: " + bodyMassIndex);

        if (bodyMassIndex < 18.5) {
            System.out.println("You are underweight");
        } else if (bodyMassIndex < 25) {
            System.out.println("You are normal");
        } else if (bodyMassIndex < 30) {
            System.out.println("You are overweight");
        } else {
            System.out.println("You are obese");
        }


    }


    public void CalculateBMR() {
        System.out.println("Now let's calculate your BMR, what is your name?");
        String name = input.nextLine();
        System.out.println("And what is your gender, male or female?");
        String gender = input.nextLine();
        System.out.println("What is your weight?");
        float weight = input.nextFloat();
        System.out.println("What is your height in cm?");
        float height = input.nextFloat();
        System.out.println("What is your age?");
        int age = input.nextInt();

        System.out.println("How much do you exercise?\n " +
                "1. Sedentary: Little or no exercise\n " +
                "2. Lightly active - Exercise 1-3 times/week\n " +
                "3. Moderately active - Exercise 4-5 times/week\n " +
                "4. Very active - Daily exercise or intense exercise 6-7 times/week\n " +
                "5. Super active - Intense exercise 8-10 times/week\n " +
                "Input one of the number above: ");
        int exercise = input.nextInt();



        if (gender.equals("male")) {
            preBMR = (66.47f + (weight * 13.7f) + (height * 5f) - (age * 6.8f));
        }
        if (gender.equals("female")) {
            preBMR = (655 + (weight * 9.6f) + (height * 1.8f) - (age * 4.7f));
        }

        switch (exercise) {
            case 1:
                basalMetabolicRate = (preBMR * 1.2f);
                break;
            case 2:
                basalMetabolicRate = (preBMR * 1.375f);
                break;
            case 3:
                basalMetabolicRate = (preBMR * 1.55f);
                break;
            case 4:
                basalMetabolicRate = (preBMR * 1.725f);
                break;
            case 5:
                basalMetabolicRate = (preBMR * 1.9f);
                break;
        }


        System.out.println("Your BMR is: " + basalMetabolicRate);
    }

    public void CalculateRun() {
        System.out.println("What is the distance you want to run in meters: ");
        float distance = input.nextFloat();
        System.out.println("Input hour: ");
        float hour = input.nextFloat();
        System.out.println("Input minutes: ");
        float minutes = input.nextFloat();
        System.out.println("input seconds: ");
        float seconds = input.nextFloat();

        timeInSeconds = (hour * 3600) + (minutes * 60) + seconds;
        timeInMinutes = (hour * 60) + (seconds / 60) + minutes;
        distanceInKilometer = distance / 1000;
        minutesPerKilometer = timeInMinutes / distanceInKilometer;
        intMinutesPerKilometer = (int) minutesPerKilometer;
        secondsPerKilometer = (minutesPerKilometer - intMinutesPerKilometer) * 60;
        metersPerSecond = distance / timeInSeconds;
        kilometerPerHour = (distance / 1000.0f) / (timeInSeconds / 3600.0f);


        System.out.println("Your speed in km/h is: " + kilometerPerHour);
        System.out.println("your speed in m/s is: " + metersPerSecond);
        System.out.println("Minutes per KM: " + intMinutesPerKilometer + "," + (int) Math.ceil(secondsPerKilometer));

    }


    public static void main(String[] args) {
        // write your code here
        Formulas runner = new Formulas();
        //runner.CalculateRun();
        //runner.CalculateBMI();
        runner.CalculateBMR();
    }
}