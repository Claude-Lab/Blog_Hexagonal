package fr.lusseau.claude.application.usecase.crud;

import fr.lusseau.claude.application.factory.IAbstractCrudDaoFactory;
import fr.lusseau.claude.application.factory.IAbstractCrudUseCaseFactory;
import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.domain.validator.EducationValidator;
import fr.lusseau.claude.infrastructure.entity.EducationEntity;
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
public class CrudEducationUseCase implements IAbstractCrudUseCaseFactory<Education> {

    private final IAbstractCrudDaoFactory<EducationEntity> dao;

    @Inject
    public CrudEducationUseCase(IAbstractCrudDaoFactory<EducationEntity> dao) {
        this.dao = dao;
    }

    @Override
    public Education create(Education education) {
        EducationEntity educationEntity = IEducationMapper.INSTANCE.educationToEducationDto(education);
        dao.create(educationEntity);
        return education;
    }

    @Override
    public Education getOne(Long id) {
        EducationEntity educationEntity = dao.getOne(id);
        if (educationEntity == null) {
            return null;
        }
        return IEducationMapper.INSTANCE.educationDtoToEducation(educationEntity);
    }

    @Override
    public List<Education> getAll() {
        List<EducationEntity> educationDTOS = dao.getAll();
        if (educationDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IEducationMapper.INSTANCE.educationDtoListToEducationList(educationDTOS);
    }

    @Override
    public void update(Education education) {
        EducationValidator.validateEducationArticle(education);
        EducationEntity educationDTO = IEducationMapper.INSTANCE.educationToEducationDto(education);
        dao.update(educationDTO);
    }

    @Override
    public void remove(Education education) {
        dao.remove(IEducationMapper.INSTANCE.educationToEducationDto(education));
    }
}
