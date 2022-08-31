package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.infrastructure.dto.CompanyDTO;
import fr.lusseau.claude.infrastructure.dto.EducationLevelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 27/08/2022
 */
@Mapper
@Named
public interface IEducationLevelMapper {

    IEducationLevelMapper INSTANCE = Mappers.getMapper(IEducationLevelMapper.class);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    EducationLevel educationLevelDtoToEducationLevel(EducationLevelDTO educationLevelDTO);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    EducationLevelDTO educationLevelToEducationLevelDto(EducationLevel educationLevel);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    List<EducationLevel> educationLevelDtoListToEducationLevelList(List<EducationLevelDTO> educationLevelDTOS);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    List<EducationLevelDTO> educationLevelListToEducationLevelDtoList(List<EducationLevel> educationLevels);
}
