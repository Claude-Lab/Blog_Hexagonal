package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.EducationLevel;
import fr.lusseau.claude.domain.validator.EducationLevelValidator;
import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
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
public class CrudEducationLevelUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudEducationLevelUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void create(EducationLevel educationLevel) {
        EducationLevelEntity educationLevelLevelDTO = IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel);
        this.factoryService.getDaoFactory().getEducationLevelDao().persistAndFlush(educationLevelLevelDTO);
    }

    public EducationLevel getOne(Long id) {
        EducationLevelEntity educationLevelLevelDTO = this.factoryService.getDaoFactory().getEducationLevelDao().findById(id);
        if (educationLevelLevelDTO == null) {
            return null;
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoToEducationLevel(educationLevelLevelDTO);
    }


    public List<EducationLevel> getAll() {
        List<EducationLevelEntity> educationLevelLevelDTOS = this.factoryService.getDaoFactory().getEducationLevelDao().listAll();
        if (educationLevelLevelDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IEducationLevelMapper.INSTANCE.educationLevelDtoListToEducationLevelList(educationLevelLevelDTOS);
    }

    public void update(EducationLevel educationLevel) {
        EducationLevelValidator.validateEducationLevel(educationLevel);
        EducationLevelEntity educationLevelLevelDTO = IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel);
        this.factoryService.getDaoFactory().getEducationLevelDao().update(educationLevelLevelDTO);
    }

    public void remove(EducationLevel educationLevel) {
        this.factoryService.getDaoFactory().getEducationLevelDao().delete(IEducationLevelMapper.INSTANCE.educationLevelToEducationLevelDto(educationLevel));
    }
}
