package com.NHTech.Book.Store.BookApplication.BookAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingController {


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World....Welcome to the big house!!!!!!!";
    }
}
