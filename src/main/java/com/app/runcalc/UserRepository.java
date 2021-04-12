package com.app.runcalc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail (String email);



}
