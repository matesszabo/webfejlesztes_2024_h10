package hu.unideb.inf.webshop.service;

import hu.unideb.inf.webshop.data.entities.Felhasznalo;
import hu.unideb.inf.webshop.service.dto.FelhasznaloDto;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    public FelhasznaloDto regisztracio(FelhasznaloDto felhasznalo);
    //felhasználónév és jelszó is elég lenne
    public Authentication bejelentkezes(FelhasznaloDto felhasznalo);
}
