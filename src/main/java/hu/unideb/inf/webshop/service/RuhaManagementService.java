package hu.unideb.inf.webshop.service;

import hu.unideb.inf.webshop.service.dto.RuhaDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RuhaManagementService {

    RuhaDto save(RuhaDto dto);
    List<RuhaDto> findAll();
    RuhaDto findById(Long id);
    void delete(Long id);
    RuhaDto update(RuhaDto dto);

    List<RuhaDto> ruhaByMeretKod(String meret);
    List<RuhaDto> ruhaByMeretDb(String meret);
    List<RuhaDto> ruhaByParams(String nev, String meret, String szin, String tipus);

}
