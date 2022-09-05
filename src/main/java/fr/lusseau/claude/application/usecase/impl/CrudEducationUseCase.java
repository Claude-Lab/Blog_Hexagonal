package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.usecase.ICrudEducationUseCase;
import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.domain.validator.EducationValidator;
import fr.lusseau.claude.infrastructure.entity.EducationEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IEducationMapper;
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
public class CrudEducationUseCase implements ICrudEducationUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudEducationUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public void create(Education education) {
        EducationEntity educationDTO = IEducationMapper.INSTANCE.educationToEducationDto(education);
        this.factoryService.getDaoFactory().getEducationDao().create(educationDTO);
    }

    @Override
    public Education getOne(Long id) {
        EducationEntity educationDTO = this.factoryService.getDaoFactory().getEducationDao().getOne(id);
        if (educationDTO == null) {
            return null;
        }
        return IEducationMapper.INSTANCE.educationDtoToEducation(educationDTO);
    }

    @Override
    public List<Education> getAll() {
        List<EducationEntity> educationDTOS = this.factoryService.getDaoFactory().getEducationDao().getAll();
        if (educationDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IEducationMapper.INSTANCE.educationDtoListToEducationList(educationDTOS);
    }

    @Override
    public void update(Education education) {
        EducationValidator.validateEducationArticle(education);
        EducationEntity educationDTO = IEducationMapper.INSTANCE.educationToEducationDto(education);
        this.factoryService.getDaoFactory().getEducationDao().update(educationDTO);
    }

    @Override
    public void remove(Education education) {
        this.factoryService.getDaoFactory().getEducationDao().remove(IEducationMapper.INSTANCE.educationToEducationDto(education));
    }
}
