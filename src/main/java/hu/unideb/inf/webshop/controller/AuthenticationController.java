package hu.unideb.inf.webshop.controller;

import hu.unideb.inf.webshop.service.AuthenticationService;
import hu.unideb.inf.webshop.service.dto.FelhasznaloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    public FelhasznaloDto regisztracio(FelhasznaloDto felhasznalo) {
        return authenticationService.regisztracio(felhasznalo);
    }

    public void bejelentkezes(FelhasznaloDto felhasznaloDto){
        authenticationService.bejelentkezes(felhasznaloDto);
    }
}
