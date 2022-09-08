package fr.lusseau.claude.application.usecase.crud;

import fr.lusseau.claude.application.factory.IAbstractCrudDaoFactory;
import fr.lusseau.claude.application.factory.IAbstractCrudUseCaseFactory;
import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.domain.validator.EducationLevelValidator;
import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;
import fr.lusseau.claude.infrastructure.mapper.IEducationLevelMapper;
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
public class CrudEducationLevelUseCase implements IAbstractCrudUseCaseFactory<EducationLevel> {

    private final IAbstractCrudDaoFactory<EducationLevelEntity> dao;

    @Inject
    public CrudEducationLevelUseCase(IAbstractCrudDaoFactory<EducationLevelEntity> dao) {
        this.dao = dao;
    }

    @Override
    public EducationLevel create(EducationLevel educationLevel) {
        EducationLevelEntity educationLevelEntity = IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel);
        dao.create(educationLevelEntity);
        if (educationLevelEntity.getId() == null) {
            return null;
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoToEducationLevel(educationLevelEntity);
    }

    @Override
    public EducationLevel getOne(Long id) {
        EducationLevelEntity educationLevelLevelDTO = dao.getOne(id);
        if (educationLevelLevelDTO == null) {
            return null;
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoToEducationLevel(educationLevelLevelDTO);
    }

    @Override
    public List<EducationLevel> getAll() {
        List<EducationLevelEntity> educationLevelLevelDTOS = dao.getAll();
        if (educationLevelLevelDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoListToEducationLevelList(educationLevelLevelDTOS);
    }

    @Override
    public void update(EducationLevel educationLevel) {
        EducationLevelValidator.validateEducationLevel(educationLevel);
        EducationLevelEntity educationLevelEntity= IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel);
        dao.update(educationLevelEntity);
    }

    @Override
    public void remove(EducationLevel educationLevel) {
        dao.remove(IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel));
    }
}
