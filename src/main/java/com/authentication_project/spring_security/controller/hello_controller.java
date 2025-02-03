package com.authentication_project.spring_security.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello_controller {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Radhe Radhe"  + request.getSession().getId();
    }
}
