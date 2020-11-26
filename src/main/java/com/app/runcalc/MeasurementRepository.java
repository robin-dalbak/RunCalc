package com.app.runcalc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer> {

    public List<Measurement> findByUserId(int userId);
    public List<Measurement> findByHeight(float height);


    Measurement findByBmi (float bmi);
}
