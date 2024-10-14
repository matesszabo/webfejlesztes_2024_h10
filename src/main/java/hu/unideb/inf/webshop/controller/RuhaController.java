package hu.unideb.inf.webshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json-t vár, json-t küld
@RequestMapping("/api")
public class RuhaController {

    @GetMapping("/hw")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloresp(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.NOT_FOUND);
    }
}









