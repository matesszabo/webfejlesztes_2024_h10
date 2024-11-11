package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.data.entities.Felhasznalo;
import hu.unideb.inf.webshop.data.repositories.FelhasznaloRepository;
import hu.unideb.inf.webshop.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private FelhasznaloRepository felhasznaloRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public Felhasznalo regisztracio(Felhasznalo felhasznalo) {
        felhasznalo.setJelszo(passwordEncoder.encode(felhasznalo.getJelszo()));
        return felhasznaloRepository.save(felhasznalo);
    }

    @Override
    public Authentication bejelentkezes(Felhasznalo felhasznalo) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(felhasznalo.getUsername(),
                        felhasznalo.getPassword())
        );
    }
}
