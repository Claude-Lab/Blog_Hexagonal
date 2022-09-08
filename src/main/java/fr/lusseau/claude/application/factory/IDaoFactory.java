package fr.lusseau.claude.application.factory;

import fr.lusseau.claude.application.dao.*;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.factory
 * @date 08/09/2022
 */
public interface IDaoFactory {

    IUserDao getUserDao();

    ICompanyDao getCompanyDao();

    IEducationDao getEducationDao();

    IExperienceDao getExperienceDao();

    IEducationLevelDao getEducationLevelDao();
}
