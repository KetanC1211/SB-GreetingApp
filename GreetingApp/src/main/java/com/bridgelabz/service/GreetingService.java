package com.bridgelabz.service;


import com.bridgelabz.model.Greeting;
import com.bridgelabz.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {


    @Autowired
    GreetingRepo greetingRepo;
    public Greeting save(Greeting greet){
        return greetingRepo.save(greet);
    }
}
