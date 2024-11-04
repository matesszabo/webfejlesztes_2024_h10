package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.data.entities.RendelesEntity;
import hu.unideb.inf.webshop.data.repositories.RendelesRepository;
import hu.unideb.inf.webshop.service.RendelesAlapAdatService;
import hu.unideb.inf.webshop.service.dto.RendelesDto;
import hu.unideb.inf.webshop.service.mapper.RendelesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesAlapAdatServiceImpl implements RendelesAlapAdatService {
    @Autowired
    RendelesRepository repo;

    @Autowired
    RendelesMapper mapper;


    @Override
    public RendelesDto getById(Long id) {
        //return mapper.rendelesEntityToDto(repo.getReferenceById(id));

        RendelesEntity entity = repo.getReferenceById(id);
        RendelesDto dto = new RendelesDto();

        dto = mapper.rendelesEntityToDto(entity);
        return dto;
    }

    @Override
    public List<RendelesDto> getAll() {
        return mapper.rendelesEntityListToDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
