package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.Experience;
import fr.lusseau.claude.domain.validator.ExperienceValidator;
import fr.lusseau.claude.infrastructure.entity.ExperienceEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IExperienceMapper;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl
 * @date 29/08/2022
 */
@Named
@LogAudited
public class CrudExperienceUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudExperienceUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void create(Experience education) {
        ExperienceEntity experienceDTO = IExperienceMapper.INSTANCE.experienceToExperienceDto(education);
        this.factoryService.getDaoFactory().getExperienceDao().persistAndFlush(experienceDTO);
    }

    public Experience getOne(Long id) {
        ExperienceEntity experienceDTO = this.factoryService.getDaoFactory().getExperienceDao().findById(id);
        if (experienceDTO == null) {
            return null;
        }
        return IExperienceMapper.INSTANCE.experienceDtoToExperience(experienceDTO);
    }


    public List<Experience> getAll() {
        List<ExperienceEntity> experienceDTOS = this.factoryService.getDaoFactory().getExperienceDao().listAll();
        if (experienceDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(experienceDTOS);
    }

    public void update(Experience education) {
        ExperienceValidator.validateExperienceArticle(education);
        ExperienceEntity experienceDTO = IExperienceMapper.INSTANCE.experienceToExperienceDto(education);
        this.factoryService.getDaoFactory().getExperienceDao().update(experienceDTO);
    }

    public void remove(Experience education) {
        this.factoryService.getDaoFactory().getExperienceDao().delete(IExperienceMapper.INSTANCE.experienceToExperienceDto(education));
    }
}
