package fr.lusseau.claude.application.factory;

import fr.lusseau.claude.application.dao.IEducationDao;
import fr.lusseau.claude.application.dao.IExperienceDao;
import fr.lusseau.claude.application.dao.IUserDao;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao.factory
 * @date 15/08/2022
 */
public interface IDaoFactory {

    IEducationDao getIEducationDao();

    IExperienceDao getIExperienceDao();

    IUserDao getIUserDao();

}