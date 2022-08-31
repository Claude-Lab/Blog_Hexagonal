package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;
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
    EducationLevel educationLevelDtoToEducationLevel(EducationLevelEntity educationLevelEntity);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    EducationLevelEntity educationLevelToEducationLevelDto(EducationLevel educationLevel);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    List<EducationLevel> educationLevelDtoListToEducationLevelList(List<EducationLevelEntity> educationLevelEntities);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    List<EducationLevelEntity> educationLevelListToEducationLevelDtoList(List<EducationLevel> educationLevels);
}
