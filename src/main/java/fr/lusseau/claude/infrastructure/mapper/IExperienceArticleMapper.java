package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Experience;
import fr.lusseau.claude.infrastructure.dto.ExperienceDTO;
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
public interface IExperienceArticleMapper {

    ExperienceDTO entityToDTO(Experience experience);

    List<ExperienceDTO> entityToDTO(Iterable<Experience> experiences);

    Experience dtoToEntity(ExperienceDTO experienceDTO);

    List<Experience> dtoToEntity(Iterable<ExperienceDTO> experienceDTOS);

}