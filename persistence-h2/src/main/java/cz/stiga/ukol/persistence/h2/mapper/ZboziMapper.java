package cz.stiga.ukol.persistence.h2.mapper;

import cz.stiga.ukol.persistence.dto.ZboziDto;
import cz.stiga.ukol.persistence.h2.model.Zbozi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZboziMapper {

    ZboziMapper INSTANCE = Mappers.getMapper(ZboziMapper.class);

    ZboziDto toDto(Zbozi zbozi);
    List<ZboziDto> toDtos(List<Zbozi> zboziList);

    @Mapping(target = "id", ignore = true)
    Zbozi toEntity(ZboziDto zboziDto);

}
