package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.infrastructure.dto.EducationLevelDTO;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 17/08/2022
 */
@LogAudited
@Mapper
public interface IEducationLevelMapper {

    EducationLevelDTO entityToDTO(EducationLevel educationLevel);

    List<EducationLevelDTO> entityToDTO(Iterable<EducationLevel> educationLevels);

    EducationLevel dtoToEntity(EducationLevelDTO educationLevelDTO);

    List<EducationLevel> dtoToEntity(Iterable<EducationLevelDTO> educationLevelDTOS);

}
