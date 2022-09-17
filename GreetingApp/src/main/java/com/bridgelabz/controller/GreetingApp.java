package com.bridgelabz.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.GreetingAppApplication;
import com.bridgelabz.model.Greeting;
import com.bridgelabz.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/displayTable")
    public List<Greeting> list() {
        return greetingService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> get(@PathVariable Integer id) {
        try {
            Greeting user = greetingService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}