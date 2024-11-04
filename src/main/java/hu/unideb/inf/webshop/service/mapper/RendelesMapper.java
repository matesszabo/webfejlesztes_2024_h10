package hu.unideb.inf.webshop.service.mapper;

import hu.unideb.inf.webshop.data.entities.RendelesEntity;
import hu.unideb.inf.webshop.service.dto.RendelesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RendelesMapper {

    @Mapping(target = "id", source = "id")
    RendelesDto rendelesEntityToDto(RendelesEntity entity);
    List<RendelesDto> rendelesEntityListToDtoList(List<RendelesEntity> entities);

    RendelesEntity rendelesDtoToEntity(RendelesDto dto);
    List<RendelesEntity> rendelesDtoListToEntityList(List<RendelesDto> dtos);

}
