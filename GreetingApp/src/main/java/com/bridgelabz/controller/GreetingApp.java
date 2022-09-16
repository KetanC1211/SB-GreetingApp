package com.bridgelabz.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.GreetingAppApplication;
import com.bridgelabz.model.Greeting;
import com.bridgelabz.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingApp {

    @Autowired
    GreetingService greetingService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
//    @GetMapping("/put/{firstName}")
//    public Greeting displayMsg (@PathVariable String firstName, @RequestParam (value= "lastName") String lastName) {
//        String fullName = firstName+" "+lastName+" ";
//        return new Greeting(counter.incrementAndGet(), String.format(template, fullName));
//    }

    @PostMapping("/save")
    public Greeting save(@RequestBody Greeting greet){
        Greeting newGreet = greetingService.save(greet);
        return newGreet;
    }

}