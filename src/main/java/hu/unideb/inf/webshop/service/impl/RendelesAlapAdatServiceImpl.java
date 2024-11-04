package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.data.repositories.RendelesRepository;
import hu.unideb.inf.webshop.service.RendelesAlapAdatService;
import hu.unideb.inf.webshop.service.dto.RendelesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesAlapAdatServiceImpl implements RendelesAlapAdatService {
    @Autowired
    RendelesRepository repo;


    @Override
    public RendelesDto getById(Long id) {
        return null;
    }

    @Override
    public List<RendelesDto> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
