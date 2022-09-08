package fr.lusseau.claude.application.usecase.crud;

import fr.lusseau.claude.application.factory.IAbstractCrudDaoFactory;
import fr.lusseau.claude.application.factory.IAbstractCrudUseCaseFactory;
import fr.lusseau.claude.domain.model.Experience;
import fr.lusseau.claude.domain.validator.ExperienceValidator;
import fr.lusseau.claude.infrastructure.entity.ExperienceEntity;
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
public class CrudExperienceUseCase implements IAbstractCrudUseCaseFactory<Experience> {

    private final IAbstractCrudDaoFactory<ExperienceEntity> dao;

    @Inject
    public CrudExperienceUseCase(IAbstractCrudDaoFactory<ExperienceEntity> dao) {
        this.dao = dao;
    }

    @Override
    public Experience create(Experience education) {
        ExperienceEntity experienceEntity = IExperienceMapper.INSTANCE.experienceToExperienceDto(education);
        dao.create(experienceEntity);
        return education;
    }

    @Override
    public Experience getOne(Long id) {
        ExperienceEntity experienceEntity =dao.getOne(id);
        if (experienceEntity == null) {
            return null;
        }
        return IExperienceMapper.INSTANCE.experienceDtoToExperience(experienceEntity);
    }

    @Override
    public List<Experience> getAll() {
        List<ExperienceEntity> experienceEntities = dao.getAll();
        if (experienceEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(experienceEntities);
    }

    @Override
    public void update(Experience education) {
        ExperienceValidator.validateExperienceArticle(education);
        ExperienceEntity experienceEntity = IExperienceMapper.INSTANCE.experienceToExperienceDto(education);
        dao.update(experienceEntity);
    }

    @Override
    public void remove(Experience education) {
        dao.remove(IExperienceMapper.INSTANCE.experienceToExperienceDto(education));
    }
}
