package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.data.entities.RuhaEntity;
import hu.unideb.inf.webshop.data.repositories.RuhaRepository;
import hu.unideb.inf.webshop.service.RuhaManagementService;
import hu.unideb.inf.webshop.service.dto.RuhaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuhaManagementServiceImpl implements RuhaManagementService {
    @Autowired
    RuhaRepository repo;

    @Override
    public RuhaDto save(RuhaDto dto) {
        return null;
    }

    @Override
    public List<RuhaDto> findAll() {
        return List.of();
    }

    @Override
    public RuhaDto findById(Long id) {
        RuhaEntity entity = repo.findById(id).orElse(null);
        RuhaDto dto = new RuhaDto();

        dto.setId(entity.getId());
        dto.setNev(entity.getNev());
        dto.setMeret(entity.getMeret());
        dto.setSzin(entity.getSzin());
        dto.setTipus(entity.getTipus());

        return dto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RuhaDto update(RuhaDto dto) {
        return null;
    }
}
