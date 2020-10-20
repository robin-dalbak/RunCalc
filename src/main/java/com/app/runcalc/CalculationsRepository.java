package com.app.runcalc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationsRepository extends CrudRepository<Info, Integer> {

    Calculations findByEmail (String email);
}
