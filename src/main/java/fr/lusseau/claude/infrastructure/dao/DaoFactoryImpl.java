package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.*;
import fr.lusseau.claude.application.factory.IDaoFactory;
import fr.lusseau.claude.infrastructure.dao.impl.*;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 08/09/2022
 */
@LogAudited
@Named
public class DaoFactoryImpl implements IDaoFactory {

    private final FactoryService factoryService;

    @Inject
    public DaoFactoryImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public IUserDao getUserDao() {
        return new UserDaoImpl(factoryService);
    }

    @Override
    public ICompanyDao getCompanyDao() {
        return new CompanyDaoImpl(factoryService);
    }

    @Override
    public IEducationDao getEducationDao() {
        return new EducationDaoImpl(factoryService);
    }

    @Override
    public IExperienceDao getExperienceDao() {
        return new ExperienceDaoImpl(factoryService);
    }

    @Override
    public IEducationLevelDao getEducationLevelDao() {
        return new EducationLevelDaoImpl(factoryService);
    }
}
