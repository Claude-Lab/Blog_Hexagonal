package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Experience;
import fr.lusseau.claude.infrastructure.dto.ExperienceDTO;
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
public interface IExperienceMapper {

    IExperienceMapper INSTANCE = Mappers.getMapper(IExperienceMapper.class);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withTitle", source = "title")
    @Mapping(target = "withBody", source = "body")
    @Mapping(target = "withUrl", source = "url")
    @Mapping(target = "withCover", source = "cover")
    @Mapping(target = "withMiniature", source = "miniature")
    @Mapping(target = "withActive", source = "active")
    @Mapping(target = "withCreatedAt", source = "createdAt")
    @Mapping(target = "withUpdatedAt", source = "updatedAt")
    @Mapping(target = "withAuthor", source = "author")
    @Mapping(target = "withCompany", source = "company")
    @Mapping(target = "withDateIn", source = "dateIn")
    @Mapping(target = "withDateOut", source = "dateOut")
    @Mapping(target = "witJobName", source = "jobName")
    Experience experienceDtoToExperience(ExperienceDTO experienceDTO);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withTitle", source = "title")
    @Mapping(target = "withBody", source = "body")
    @Mapping(target = "withUrl", source = "url")
    @Mapping(target = "withCover", source = "cover")
    @Mapping(target = "withMiniature", source = "miniature")
    @Mapping(target = "withActive", source = "active")
    @Mapping(target = "withCreatedAt", source = "createdAt")
    @Mapping(target = "withUpdatedAt", source = "updatedAt")
    @Mapping(target = "withAuthor", source = "author")
    @Mapping(target = "withCompany", source = "company")
    @Mapping(target = "withDateIn", source = "dateIn")
    @Mapping(target = "withDateOut", source = "dateOut")
    @Mapping(target = "witJobName", source = "jobName")
    ExperienceDTO experienceToExperienceDto(Experience experience);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withTitle", source = "title")
    @Mapping(target = "withBody", source = "body")
    @Mapping(target = "withUrl", source = "url")
    @Mapping(target = "withCover", source = "cover")
    @Mapping(target = "withMiniature", source = "miniature")
    @Mapping(target = "withActive", source = "active")
    @Mapping(target = "withCreatedAt", source = "createdAt")
    @Mapping(target = "withUpdatedAt", source = "updatedAt")
    @Mapping(target = "withAuthor", source = "author")
    @Mapping(target = "withCompany", source = "company")
    @Mapping(target = "withDateIn", source = "dateIn")
    @Mapping(target = "withDateOut", source = "dateOut")
    @Mapping(target = "witJobName", source = "jobName")
    List<Experience> experienceDtoListToExperienceList(List<ExperienceDTO> experienceDTOS);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withTitle", source = "title")
    @Mapping(target = "withBody", source = "body")
    @Mapping(target = "withUrl", source = "url")
    @Mapping(target = "withCover", source = "cover")
    @Mapping(target = "withMiniature", source = "miniature")
    @Mapping(target = "withActive", source = "active")
    @Mapping(target = "withCreatedAt", source = "createdAt")
    @Mapping(target = "withUpdatedAt", source = "updatedAt")
    @Mapping(target = "withAuthor", source = "author")
    @Mapping(target = "withCompany", source = "company")
    @Mapping(target = "withDateIn", source = "dateIn")
    @Mapping(target = "withDateOut", source = "dateOut")
    @Mapping(target = "witJobName", source = "jobName")
    List<ExperienceDTO> experienceListToExperienceDtoList(List<Experience> experiences);
}
