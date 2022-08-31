package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.infrastructure.entity.EducationEntity;
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
public interface IEducationMapper {

    IEducationMapper INSTANCE = Mappers.getMapper(IEducationMapper.class);

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
    @Mapping(target = "withLevel", source = "level")
    Education educationDtoToEducation(EducationEntity educationDTO);

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
    @Mapping(target = "withLevel", source = "level")
    EducationEntity educationToEducationDto(Education education);

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
    @Mapping(target = "withLevel", source = "level")
    List<Education> educationDtoListToEducationList(List<EducationEntity> educationDTOS);

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
    @Mapping(target = "withLevel", source = "level")
    List<EducationEntity> educationListToEducationDtoList(List<Education> educations);
}
