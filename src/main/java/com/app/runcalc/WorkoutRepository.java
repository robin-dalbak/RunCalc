package com.app.runcalc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Integer> {


    public List<Workout> findByUserId(int userId);

}
