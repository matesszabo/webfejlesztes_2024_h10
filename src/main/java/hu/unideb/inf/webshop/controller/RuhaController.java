package hu.unideb.inf.webshop.controller;

import hu.unideb.inf.webshop.data.entities.RuhaEntity;
import hu.unideb.inf.webshop.data.repositories.RuhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/allRuha")
    public List<RuhaEntity> getAllRuha(){
        return repository.findAll();
    }

    // /ruha/M
    @GetMapping("/ruha/{meret}")
    public List<RuhaEntity> getRuhaByMeret(@PathVariable String meret){
        List<RuhaEntity> meretValogatott = new ArrayList<>();
        meretValogatott = repository.findAll()
                .stream()
                .filter(x -> x.getMeret().equals(meret))
                .toList();

        return meretValogatott;
    }

    // /ruha?meret=M
    @GetMapping("/ruha")
    public List<RuhaEntity> getRuhaByMeretDb(@RequestParam String meret){
        return repository.findAllByMeret(meret);
    }

    @GetMapping("/filteredruha")
    public List<RuhaEntity> getFilteredRuha(@RequestParam(required = false) String nev,
                                            @RequestParam(required = false) String meret,
                                            @RequestParam(required = false) String szin,
                                            @RequestParam(required = false) String tipus){
        return repository.findAll().stream()
                .filter(x -> nev == null || x.getNev().equals(nev))
                .filter(x -> meret == null || x.getMeret().equals(meret))
                .filter(x -> szin == null || x.getSzin().equals(szin))
                .filter(x -> tipus == null || x.getTipus().equals(tipus))
                .toList();

    }
}









