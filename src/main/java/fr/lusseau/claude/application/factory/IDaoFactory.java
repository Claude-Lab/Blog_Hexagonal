package fr.lusseau.claude.application.factory;

import fr.lusseau.claude.application.dao.*;
import fr.lusseau.claude.infrastructure.dao.impl.*;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao.factory
 * @date 15/08/2022
 */
public interface IDaoFactory {

    IUserDao getUserDao();

    ICompanyDao getCompanyDao();

    IEducationLevelDao getEducationLevelDao();

    IEducationDao getEducationDao();

    IExperienceDao getExperienceDao();

}