package hu.unideb.inf.webshop.service;

import hu.unideb.inf.webshop.service.dto.RendelesDto;

import java.util.List;

public interface RendelesAlapAdatService {

    RendelesDto getById(Long id);
    List<RendelesDto> getAll();
    void deleteById(Long id);
    
}
