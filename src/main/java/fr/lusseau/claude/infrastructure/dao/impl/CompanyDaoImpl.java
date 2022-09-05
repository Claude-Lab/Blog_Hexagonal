package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.application.dao.ICompanyDao;
import fr.lusseau.claude.infrastructure.entity.CompanyEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 27/08/2022
 */
@Named("CompanyDaoImpl")
@LogAudited
public class CompanyDaoImpl implements ICompanyDao {

    private final FactoryService factoryService;

    @Inject
    public CompanyDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public List<CompanyEntity> getAll() {
        return factoryService.createEntityManager().createQuery("FROM CompanyEntity").getResultList();
    }

    @Override
    public CompanyEntity getOne(Long id) {
        return factoryService.createEntityManager().find(CompanyEntity.class, id);
    }

    @Override
    public void create(CompanyEntity companyEntity) {
        factoryService.createEntityManager().persist(companyEntity);
    }

    @Override
    public void update(CompanyEntity companyEntity) {
        factoryService.createEntityManager().merge(companyEntity);
    }

    @Override
    public void remove(CompanyEntity companyEntity) {
        companyEntity = getOne(companyEntity.getId());
        factoryService.createEntityManager().remove(companyEntity);
    }

    @Override
    public List<CompanyEntity> isNameExist(String name) {
        return factoryService.createEntityManager().createNamedQuery("Company.isNameExist").setParameter("name", name).getResultList();
    }

}