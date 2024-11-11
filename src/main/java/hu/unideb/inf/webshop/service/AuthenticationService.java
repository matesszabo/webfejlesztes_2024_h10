package hu.unideb.inf.webshop.service;

import hu.unideb.inf.webshop.data.entities.Felhasznalo;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    public Felhasznalo regisztracio(Felhasznalo felhasznalo);
    //felhasználónév és jelszó is elég lenne
    public Authentication bejelentkezes(Felhasznalo felhasznalo);
}
