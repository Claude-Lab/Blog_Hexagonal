package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.application.dao.IExperienceDao;
import fr.lusseau.claude.application.factory.IAbstractCrudDaoFactory;
import fr.lusseau.claude.infrastructure.entity.ExperienceEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
@Named("ExperienceDaoImpl")
@LogAudited
public class ExperienceDaoImpl implements IAbstractCrudDaoFactory<ExperienceEntity>, IExperienceDao {

    private final FactoryService factoryService;

    @Inject
    public ExperienceDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public List<ExperienceEntity> getAll() {
        return factoryService.createEntityManager().createQuery("FROM ExperienceEntity").getResultList();
    }

    @Override
    public ExperienceEntity getOne(Long id) {
        return factoryService.createEntityManager().find(ExperienceEntity.class, id);
    }

    @Override
    public void create(ExperienceEntity experienceEntity) {
        factoryService.createEntityManager().persist(experienceEntity);
    }

    @Override
    public void update(ExperienceEntity experienceEntity) {
        factoryService.createEntityManager().merge(experienceEntity);
    }

    @Override
    public void remove(ExperienceEntity experienceEntity) {
        experienceEntity = getOne(experienceEntity.getId());
        factoryService.createEntityManager().remove(experienceEntity);
    }

    @Override
    public List<ExperienceEntity> isTitleExist(String title) {
        return factoryService.createEntityManager().createNamedQuery("Experience.isTitleExist").setParameter("title", title).getResultList();
    }

    @Override
    public List<ExperienceEntity> isUrlExist(String url) {
        return factoryService.createEntityManager().createNamedQuery("Experience.isUrlExist").setParameter("url", url).getResultList();
    }

}
