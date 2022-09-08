package fr.lusseau.claude.application.usecase.check;

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

    /**
     * Experience check title.
     * @param title title
     * @param id id
     * @return false || true
     */
    @Override
    public boolean checkIfTitleExperienceExist(String title, Long id) {
        List<Experience> experiences = IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(this.factoryService.getDaoFactory().getExperienceDao().isTitleExist(title));
        if (id == null) {
            return experiences != null;
        } else {
            for (Experience experience : experiences) {
                if (!Objects.equals(experience.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Experience check url.
     * @param url url
     * @param id id
     * @return false || true
     */
    @Override
    public boolean checkIfUrlExperienceExist(String url, Long id) {
        List<Experience> experiences = IExperienceMapper.INSTANCE.experienceDtoListToExperienceList(this.factoryService.getDaoFactory().getExperienceDao().isUrlExist(url));
        if (id == null) {
            return experiences != null;
        } else {
            for (Experience experience : experiences) {
                if (!Objects.equals(experience.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Education check title.
     * @param title title
     * @param id id
     * @return false || true
     */
    @Override
    public boolean checkIfTitleEducationExist(String title, Long id) {
        List<Education> educations = IEducationMapper.INSTANCE.educationDtoListToEducationList(this.factoryService.getDaoFactory().getEducationDao().isTitleExist(title));
        if (id == null) {
            return educations != null;
        } else {
            for (Education education : educations) {
                if (!Objects.equals(education.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Education check url.
     * @param url url
     * @param id id
     * @return false || true
     */
    @Override
    public boolean checkIfUrlEducationExist(String url, Long id) {
        List<Education> educations = IEducationMapper.INSTANCE.educationDtoListToEducationList(this.factoryService.getDaoFactory().getEducationDao().isUrlExist(url));
        if (id == null) {
            return educations != null;
        } else {
            for (Education education : educations) {
                if (!Objects.equals(education.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * EducationLevel check name.
     * @param name name
     * @param id id
     * @return false || true
     */
    @Override
    public boolean checkIfEducationLevelNameExist(String name, Long id) {
        List<EducationLevel> educationLevels = IEducationLevelMapper.INSTANCE.educationLevelDtoListToEducationLevelList(factoryService.getDaoFactory().getEducationLevelDao().findByName(name));
        if (id == null) {
            return educationLevels != null;
        } else {
            for (EducationLevel educationLevel : educationLevels) {
                if (!Objects.equals(educationLevel.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Company check name.
     * @param name name
     * @param id id
     * @return false || true
     */
    @Override
    public boolean checkIfCompanyNameExist(String name, Long id) {
        List<Company> companies = ICompanyMapper.INSTANCE.companyDtoListToCompanyList(this.factoryService.getDaoFactory().getCompanyDao().isNameExist(name));
        if (id == null) {
            return companies != null;
        } else {
            for (Company company : companies) {
                if (!Objects.equals(company.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * User check mail.
     * @param email email
     * @param id id
     * @return false || true
     */
    @Override
    public boolean isEmailExist(String email, Long id) {
        List<User> users = IUserMapper.INSTANCE.userDtoListToUserList(this.factoryService.getDaoFactory().getUserDao().findByEmail(email));
        if (id == null) {
            return users != null;
        } else {
            for (User user : users) {
                if (!Objects.equals(user.getId(), id)) {
                    return true;
                }
            }
            return false;
        }
    }
}
