package hu.unideb.inf.webshop.controller;

import hu.unideb.inf.webshop.data.entities.RuhaEntity;
import hu.unideb.inf.webshop.data.repositories.RuhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //json-t vár, json-t küld
@RequestMapping("/api")
public class RuhaController {

    @Autowired
    RuhaRepository repository;

    @GetMapping("/hw")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloresp(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/saveruha")
    public RuhaEntity saveRuha(@RequestBody RuhaEntity entity){
        return repository.save(entity);
    }

    //entity rendelkezik ID-val, akkor update, amúgy save
    @PutMapping("/updateruha")
    public RuhaEntity updateRuha(@RequestBody RuhaEntity entity){
        return repository.save(entity);
    }

    // /api/deleteruha?id=x
    @DeleteMapping("/deleteruha")
    public void deleteRuha(@RequestParam Long id){
        repository.deleteById(id);
    }
}









