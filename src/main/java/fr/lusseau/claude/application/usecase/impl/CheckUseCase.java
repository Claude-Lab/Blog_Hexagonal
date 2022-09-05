package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.usecase.ICheckUseCase;
import fr.lusseau.claude.domain.model.*;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.*;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl.company
 * @date 27/08/2022
 */
@Named
@LogAudited
public class CheckUseCase implements ICheckUseCase {
    private final FactoryService factoryService;

    @Inject
    public CheckUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }


    @Override
    public boolean checkIfTitleExperienceExist(String title) {
        List<Experience> experiences = IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(this.factoryService.getDaoFactory().getExperienceDao().isTitleExist(title));
        return experiences.stream().anyMatch(experience -> experience.getTitle().equals(title));
    }

    @Override
    public boolean checkIfUrlExperienceExist(String url) {
        List<Experience> experiences = IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(this.factoryService.getDaoFactory().getExperienceDao().isUrlExist(url));
        return experiences.stream().anyMatch(experience -> experience.getUrl().equals(url));
    }

    @Override
    public boolean checkIfTitleEducationExist(String title) {
        List<Education> educations = IEducationMapper.INSTANCE.educationDtoListToEducationList(this.factoryService.getDaoFactory().getEducationDao().isTitleExist(title));
        return educations.stream().anyMatch(education -> education.getTitle().equals(title));
    }

    @Override
    public boolean checkIfUrlEducationExist(String url) {
        List<Education> educations = IEducationMapper.INSTANCE.educationDtoListToEducationList(this.factoryService.getDaoFactory().getEducationDao().isUrlExist(url));
        return educations.stream().anyMatch(education -> education.getUrl().equals(url));
    }

    @Override
    public boolean checkIfEducationLevelNameExist(String name) {
        List<EducationLevel> educationLevels = IEducationLevelMapper.INSTANCE.educationLevelDtoListToEducationLevelList(factoryService.getDaoFactory().getEducationLevelDao().isNameExist(name));
        return educationLevels.stream().anyMatch(educationLevel -> educationLevel.getName().equals(name));
    }

    @Override
    public boolean checkIfCompanyNameExist(String name) {
        List<Company> companies = ICompanyMapper.INSTANCE.companyDtoListToCompanyList(this.factoryService.getDaoFactory().getCompanyDao().isNameExist(name));
        return companies.stream().anyMatch(company -> company.getName().equals(name));
    }

    @Override
    public boolean isEmailExist(String email) {
        List<User> users = IUserMapper.INSTANCE.userDtoListToUserList(this.factoryService.getDaoFactory().getUserDao().isEmailExist(email));
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
}
