package hu.unideb.inf.webshop.controller;

import hu.unideb.inf.webshop.service.dto.RuhaDto;
import hu.unideb.inf.webshop.data.repositories.RuhaRepository;
import hu.unideb.inf.webshop.service.RuhaManagementService;
import hu.unideb.inf.webshop.service.dto.RuhaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController //json-t vár, json-t küld
@RequestMapping("/api")
public class RuhaController {

    @Autowired
    RuhaManagementService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hw")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloresp(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/saveruha")
    public RuhaDto saveRuha(@RequestBody RuhaDto dto){
        return service.save(dto);
    }

    //entity rendelkezik ID-val, akkor update, amúgy save
    @PutMapping("/updateruha")
    public RuhaDto updateRuha(@RequestBody RuhaDto dto){
        return service.update(dto);
    }

    // /api/deleteruha?id=x
    @DeleteMapping("/deleteruha")
    public void deleteRuha(@RequestParam Long id){
        service.delete(id);
    }

    @GetMapping("/allRuha")
    public List<RuhaDto> getAllRuha(){
        return service.findAll();
    }

    // /ruha/M
    @GetMapping("/ruha/{meret}")
    public List<RuhaDto> getRuhaByMeret(@PathVariable String meret){
        return service.ruhaByMeretKod(meret);
    }

    // /ruha?meret=M
    @GetMapping("/ruha")
    public List<RuhaDto> getRuhaByMeretDb(@RequestParam String meret){
        return service.ruhaByMeretDb(meret);
    }

    @GetMapping("/filteredruha")
    public List<RuhaDto> getFilteredRuha(@RequestParam(required = false) String nev,
                                            @RequestParam(required = false) String meret,
                                            @RequestParam(required = false) String szin,
                                            @RequestParam(required = false) String tipus){
        return service.ruhaByParams(nev,meret,szin,tipus);

    }
}









