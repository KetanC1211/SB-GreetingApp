package com.bridgelabz.repository;


import com.bridgelabz.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//<Greeting -- TabaleName , long ---id--primaryKey>

@Repository
public interface GreetingRepo extends JpaRepository<Greeting , Long> {
}
