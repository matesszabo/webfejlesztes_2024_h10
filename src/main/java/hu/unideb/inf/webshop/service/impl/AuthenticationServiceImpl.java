package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.data.entities.Felhasznalo;
import hu.unideb.inf.webshop.data.repositories.FelhasznaloRepository;
import hu.unideb.inf.webshop.service.AuthenticationService;
import hu.unideb.inf.webshop.service.dto.FelhasznaloDto;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public FelhasznaloDto regisztracio(FelhasznaloDto felhasznalo) {
        felhasznalo.setJelszo(passwordEncoder.encode(felhasznalo.getJelszo()));

        Felhasznalo entity = new Felhasznalo();
        entity.setId(felhasznalo.getId());
        entity.setJelszo(felhasznalo.getJelszo());
        entity.setEmail(felhasznalo.getEmail());
        entity.setCim(felhasznalo.getCim());
        entity.setNem(felhasznalo.getNem());
        entity.setSzuldate(felhasznalo.getSzuldate());
        entity.setTelefon(felhasznalo.getTelefon());


        return modelMapper.map(felhasznaloRepository.save(entity), FelhasznaloDto.class);
    }

    @Override
    public Authentication bejelentkezes(FelhasznaloDto felhasznalo) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(felhasznalo.getEmail(),
                        felhasznalo.getJelszo())
        );
    }
}
