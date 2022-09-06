package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.usecase.ICrudEducationLevelUseCase;
import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.domain.validator.EducationLevelValidator;
import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;
import fr.lusseau.claude.infrastructure.entity.UserEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IEducationLevelMapper;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;
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
public class CrudEducationLevelUseCase implements ICrudEducationLevelUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudEducationLevelUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public EducationLevel create(EducationLevel educationLevel) {
        EducationLevelEntity educationLevelEntity = IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel);
        factoryService.getDaoFactory().getEducationLevelDao().create(educationLevelEntity);
        if (educationLevelEntity.getId() == null) {
            return null;
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoToEducationLevel(educationLevelEntity);
    }

    @Override
    public EducationLevel getOne(Long id) {
        EducationLevelEntity educationLevelLevelDTO = this.factoryService.getDaoFactory().getEducationLevelDao().getOne(id);
        if (educationLevelLevelDTO == null) {
            return null;
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoToEducationLevel(educationLevelLevelDTO);
    }

    @Override
    public List<EducationLevel> getAll() {
        List<EducationLevelEntity> educationLevelLevelDTOS = this.factoryService.getDaoFactory().getEducationLevelDao().getAll();
        if (educationLevelLevelDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoListToEducationLevelList(educationLevelLevelDTOS);
    }

    @Override
    public void update(EducationLevel educationLevel) {
        EducationLevelValidator.validateEducationLevel(educationLevel);
        EducationLevelEntity educationLevelEntity= IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel);
        factoryService.getDaoFactory().getEducationLevelDao().update(educationLevelEntity);
    }

    @Override
    public void remove(EducationLevel educationLevel) {
        this.factoryService.getDaoFactory().getEducationLevelDao().remove(IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel));
    }
}
