package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkout(int userId) {
        List<Workout> workouts = new ArrayList<>();
        workoutRepository.findByUserId(userId)
                .forEach(workouts::add);
        return workouts;
    }

    public Optional<Workout> getWorkout(int id) {
        return workoutRepository.findById(id);
    }

    public void addWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public void updateWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public void deleteWorkout(int id) {
        workoutRepository.deleteById(id);
    }


}
