package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.usecase.ICrudExperienceUseCase;
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
public class CrudExperienceUseCase implements ICrudExperienceUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudExperienceUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public void create(Experience education) {
        ExperienceEntity experienceDTO = IExperienceMapper.INSTANCE.experienceToExperienceDto(education);
        this.factoryService.getDaoFactory().getExperienceDao().create(experienceDTO);
    }

    @Override
    public Experience getOne(Long id) {
        ExperienceEntity experienceDTO = this.factoryService.getDaoFactory().getExperienceDao().getOne(id);
        if (experienceDTO == null) {
            return null;
        }
        return IExperienceMapper.INSTANCE.experienceDtoToExperience(experienceDTO);
    }

    @Override
    public List<Experience> getAll() {
        List<ExperienceEntity> experienceDTOS = this.factoryService.getDaoFactory().getExperienceDao().getAll();
        if (experienceDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(experienceDTOS);
    }

    @Override
    public void update(Experience education) {
        ExperienceValidator.validateExperienceArticle(education);
        ExperienceEntity experienceDTO = IExperienceMapper.INSTANCE.experienceToExperienceDto(education);
        this.factoryService.getDaoFactory().getExperienceDao().update(experienceDTO);
    }

    @Override
    public void remove(Experience education) {
        this.factoryService.getDaoFactory().getExperienceDao().remove(IExperienceMapper.INSTANCE.experienceToExperienceDto(education));
    }
}
