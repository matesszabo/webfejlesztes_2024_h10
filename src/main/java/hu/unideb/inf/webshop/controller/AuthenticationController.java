package hu.unideb.inf.webshop.controller;

import hu.unideb.inf.webshop.service.AuthenticationService;
import hu.unideb.inf.webshop.service.dto.BejelentkezesDto;
import hu.unideb.inf.webshop.service.dto.FelhasznaloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/regisztracio")
    public String regisztracio(@RequestBody FelhasznaloDto felhasznalo) {
        return authenticationService.regisztracio(felhasznalo);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto bejelentkezesDto){
        return authenticationService.bejelentkezes(bejelentkezesDto);
    }
}
