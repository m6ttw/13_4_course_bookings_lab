package com.codeclan.example.coursebooking.controllers;

import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.CourseRepository;
import com.codeclan.example.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age

    ){ if (courseName != null && town != null && age != null){
        return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseNameAndAgeGreaterThanIgnoreCase(town, courseName, age), HttpStatus.OK);
    } if(courseName != null && town != null){
        return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
    }
        if(courseName != null){
        return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
    }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
