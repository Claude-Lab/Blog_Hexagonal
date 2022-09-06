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
        for (Experience experience : experiences) {
            Long withSameTitle = experience.getId();
            if (Objects.equals(withSameTitle, experience.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfUrlExperienceExist(String url) {
        List<Experience> experiences = IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(this.factoryService.getDaoFactory().getExperienceDao().isUrlExist(url));
        for (Experience experience : experiences) {
            Long withSameUrl = experience.getId();
            if (Objects.equals(withSameUrl, experience.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfTitleEducationExist(String title) {
        List<Education> educations = IEducationMapper.INSTANCE.educationDtoListToEducationList(this.factoryService.getDaoFactory().getEducationDao().isTitleExist(title));
        for (Education education : educations) {
            Long withSameTitle = education.getId();
            if (Objects.equals(withSameTitle, education.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfUrlEducationExist(String url) {
        List<Education> educations = IEducationMapper.INSTANCE.educationDtoListToEducationList(this.factoryService.getDaoFactory().getEducationDao().isUrlExist(url));
        for (Education education : educations) {
            Long withSameUrl = education.getId();
            if (Objects.equals(withSameUrl, education.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfEducationLevelNameExist(String name) {
        List<EducationLevel> educationLevels = IEducationLevelMapper.INSTANCE.educationLevelDtoListToEducationLevelList(factoryService.getDaoFactory().getEducationLevelDao().findByName(name));
        for (EducationLevel educationLevel : educationLevels) {
            Long withSameName = educationLevel.getId();
            if (Objects.equals(withSameName, educationLevel.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfCompanyNameExist(String name) {
        List<Company> companies = ICompanyMapper.INSTANCE.companyDtoListToCompanyList(this.factoryService.getDaoFactory().getCompanyDao().isNameExist(name));
        for (Company company : companies) {
            Long withSameName = company.getId();
            if (Objects.equals(withSameName, company.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmailExist(String email, Long id) {
        List<User> users = IUserMapper.INSTANCE.userDtoListToUserList(this.factoryService.getDaoFactory().getUserDao().findByEmail(email));
        for (User user : users) {
            if (!Objects.equals(id, user.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean  isEmailExistForCreate(String email) {
        List<User> users = IUserMapper.INSTANCE.userDtoListToUserList(this.factoryService.getDaoFactory().getUserDao().findByEmail(email));
        return users != null;
    }
}
