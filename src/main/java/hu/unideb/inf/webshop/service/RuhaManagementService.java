package hu.unideb.inf.webshop.service;

import hu.unideb.inf.webshop.service.dto.RuhaDto;

import java.util.List;

public interface RuhaManagementService {

    RuhaDto save(RuhaDto dto);
    List<RuhaDto> findAll();
    RuhaDto findById(Long id);
    void delete(Long id);
    RuhaDto update(RuhaDto dto);

}
