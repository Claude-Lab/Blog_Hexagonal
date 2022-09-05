package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.application.dao.IEducationDao;
import fr.lusseau.claude.infrastructure.entity.EducationEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 15/08/2022
 */
@Named("EducationDaoImpl")
@LogAudited
@ApplicationScoped
public class EducationDaoImpl implements IEducationDao {

    private final FactoryService factoryService;

    @Inject
    public EducationDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public List<EducationEntity> getAll() {
        return factoryService.createEntityManager().createQuery("FROM EducationEntity").getResultList();
    }

    @Override
    public EducationEntity getOne(Long id) {
        return factoryService.createEntityManager().find(EducationEntity.class, id);
    }

    @Override
    public void create(EducationEntity educationEntity) {
        factoryService.createEntityManager().persist(educationEntity);
    }

    @Override
    public void update(EducationEntity educationEntity) {
        factoryService.createEntityManager().merge(educationEntity);
    }

    @Override
    public void remove(EducationEntity educationEntity) {
        educationEntity = getOne(educationEntity.getId());
        factoryService.createEntityManager().remove(educationEntity);
    }

    @Override
    public List<EducationEntity> isTitleExist(String title) {
        return factoryService.createEntityManager().createNamedQuery("Education.isTitleExist").setParameter("title", title).getResultList();
    }

    @Override
    public List<EducationEntity> isUrlExist(String url) {
        return factoryService.createEntityManager().createNamedQuery("Education.isUrlExist").setParameter("url", url).getResultList();
    }

}