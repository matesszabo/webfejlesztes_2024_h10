package hu.unideb.inf.webshop.controller;

import hu.unideb.inf.webshop.service.AuthenticationService;
import hu.unideb.inf.webshop.service.dto.FelhasznaloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/regisztracio")
    public FelhasznaloDto regisztracio(@RequestBody FelhasznaloDto felhasznalo) {
        return authenticationService.regisztracio(felhasznalo);
    }

    @PostMapping("/bejelentkezes")
    public void bejelentkezes(@RequestBody FelhasznaloDto felhasznaloDto){
        authenticationService.bejelentkezes(felhasznaloDto);
    }
}
