package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.infrastructure.dto.EducationDTO;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 15/08/2022
 */
@LogAudited
@Mapper
public interface IEducationArticleMapper {

    EducationDTO entityToDTO(Education education);

    List<EducationDTO> entityToDTO(Iterable<Education> educations);

    Education dtoToEntity(EducationDTO educationDTO);

    List<Education> dtoToEntity(Iterable<EducationDTO> educationDTOS);

}
