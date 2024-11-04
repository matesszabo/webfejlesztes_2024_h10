package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.data.entities.RuhaEntity;
import hu.unideb.inf.webshop.data.repositories.RuhaRepository;
import hu.unideb.inf.webshop.service.RuhaManagementService;
import hu.unideb.inf.webshop.service.dto.RuhaDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuhaManagementServiceImpl implements RuhaManagementService {
    @Autowired
    RuhaRepository repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public RuhaDto save(RuhaDto dto) {
        /*return modelMapper.map(
                repo.save(modelMapper.map(dto, RuhaEntity.class))
                ,RuhaDto.class);
        */
        RuhaEntity ruhaEntity = modelMapper.map(dto, RuhaEntity.class);
        ruhaEntity = repo.save(ruhaEntity);

        return modelMapper.map(ruhaEntity, RuhaDto.class);
    }

    @Override
    public List<RuhaDto> findAll() {
        List<RuhaEntity> list = repo.findAll();
        List<RuhaDto> dtos = new ArrayList<>();

        dtos = modelMapper.map(list, new TypeToken<List<RuhaDto>>(){}.getType());
        return dtos;
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

    @Override
    public List<RuhaDto> ruhaByMeretKod(String meret) {
        List<RuhaEntity> meretValogatott = new ArrayList<>();
        meretValogatott = repo.findAll()
                .stream()
                .filter(x -> x.getMeret().equals(meret))
                .toList();

        return modelMapper.map(meretValogatott, new TypeToken<List<RuhaDto>>(){}.getType());
    }

    @Override
    public List<RuhaDto> ruhaByMeretDb(String meret) {
        return List.of();
    }

    @Override
    public List<RuhaDto> ruhaByParams(String nev, String meret, String szin, String tipus) {
        return List.of();
    }
}
