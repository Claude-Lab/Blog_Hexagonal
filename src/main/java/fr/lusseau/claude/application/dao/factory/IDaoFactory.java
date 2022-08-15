package fr.lusseau.claude.application.dao.factory;

import fr.lusseau.claude.application.dao.IEducationDao;
import fr.lusseau.claude.application.dao.IExperienceDao;
import fr.lusseau.claude.application.dao.IUserDao;

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