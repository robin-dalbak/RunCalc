package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;
    
    public List<Measurement> getAllMeasurement(int userId) {
        List<Measurement> measurements = new ArrayList<>();
        measurementRepository.findByUserId(userId)
                .forEach(measurements::add);
        return measurements;
    }

    public Optional<Measurement> getMeasurement(int id) {
        return measurementRepository.findById(id);
    }

    public void addMeasurement(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public void updateMeasurement(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public void deleteMeasurement(int id) {
        measurementRepository.deleteById(id);
    }

//    public void calculateBMI(float height, float weight, float bmi) {
//
//    }


}
