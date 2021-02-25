package com.codeclan.example.coursebooking.components;

import com.codeclan.example.coursebooking.models.Booking;
import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.BookingRepository;
import com.codeclan.example.coursebooking.repositories.CourseRepository;
import com.codeclan.example.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Bob", "Edinburgh", 30);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Dave", "Glasgow", 42);
        customerRepository.save(customer2);

        Course course1 = new Course("Software Development", "Edinburgh", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Hardware Development", "Glasgow", 1);
        courseRepository.save(course2);

        Booking booking1 = new Booking("25/02/2021", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("12/04/2020", course2, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("23/05/2019", course2, customer1);
        bookingRepository.save(booking3);

    }
}
