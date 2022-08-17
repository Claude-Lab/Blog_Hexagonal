package fr.lusseau.claude.infrastructure.dao.factory;

import fr.lusseau.claude.application.dao.IEducationDao;
import fr.lusseau.claude.application.dao.IExperienceDao;
import fr.lusseau.claude.application.dao.IUserDao;
import fr.lusseau.claude.application.factory.IDaoFactory;
import fr.lusseau.claude.infrastructure.dao.EducationDaoImpl;
import fr.lusseau.claude.infrastructure.dao.ExperienceDaoImpl;
import fr.lusseau.claude.infrastructure.dao.UserDaoImpl;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao.factory
 * @date 15/08/2022
 */
@Named("DaoFactoryImpl")
@LogAudited
public class DaoFactoryImpl implements IDaoFactory {

    private final FactoryService factoryService;

    @Inject
    public DaoFactoryImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public IEducationDao getIEducationDao() {
        return new EducationDaoImpl(factoryService);
    }

    @Override
    public IExperienceDao getIExperienceDao() {
        return new ExperienceDaoImpl(factoryService);
    }

    @Override
    public IUserDao getIUserDao() {
        return new UserDaoImpl(factoryService);
    }

}
