package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.infrastructure.entity.*;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl.company
 * @date 27/08/2022
 */
@Named
@LogAudited
public class CheckUseCase {
    private final FactoryService factoryService;

    @Inject
    public CheckUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }


    public boolean checkIfTitleExperienceExist(String title) {
        ExperienceEntity experienceDTO = this.factoryService.getDaoFactory().getExperienceDao().isTitleExist(title);
        return experienceDTO != null;
    }

    public boolean checkIfUrlExperienceExist(String url) {
        ExperienceEntity experienceDTO = this.factoryService.getDaoFactory().getExperienceDao().isUrlExist(url);
        return experienceDTO != null;
    }

    public boolean checkIfTitleEducationExist(String title) {
        EducationEntity educationDTO = this.factoryService.getDaoFactory().getEducationDao().isTitleExist(title);
        return educationDTO != null;
    }

    public boolean checkIfEducationLevelNameExist(String name) {
        EducationLevelEntity educationLevelEntity = factoryService.getDaoFactory().getEducationLevelDao().isNameExist(name);
        return educationLevelEntity != null;
    }

    public boolean checkIfUrlEducationExist(String url) {
        EducationEntity educationDTO = this.factoryService.getDaoFactory().getEducationDao().isUrlExist(url);
        return educationDTO != null;
    }

    public boolean checkIfCompanyNameExist(String name) {
        CompanyEntity companyEntity = this.factoryService.getDaoFactory().getCompanyDao().isNameExist(name);
        return companyEntity != null;
    }

    public boolean isEmailExist(String email) {
        UserEntity userEntity = this.factoryService.getDaoFactory().getUserDao().isEmailExist(email);
        return userEntity != null;
    }
}
