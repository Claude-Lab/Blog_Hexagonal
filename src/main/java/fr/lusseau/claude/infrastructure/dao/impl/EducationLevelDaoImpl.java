package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.application.dao.IEducationLevelDao;
import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;
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
@LogAudited
@Named("EducationLevelDaoImpl")
public class EducationLevelDaoImpl implements IEducationLevelDao {


    private final FactoryService factoryService;

    @Inject
    public EducationLevelDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public List<EducationLevelEntity> getAll() {
        return factoryService.createEntityManager().createQuery("FROM EducationLevelEntity").getResultList();
    }

    @Override
    public EducationLevelEntity getOne(Long id) {
        return factoryService.createEntityManager().find(EducationLevelEntity.class, id);
    }

    @Override
    public void create(EducationLevelEntity educationLevelEntity) {
        factoryService.createEntityManager().persist(educationLevelEntity);
    }

    @Override
    public void update(EducationLevelEntity educationLevelEntity) {
        factoryService.createEntityManager().merge(educationLevelEntity);
    }

    @Override
    public void remove(EducationLevelEntity educationLevelEntity) {
        educationLevelEntity = getOne(educationLevelEntity.getId());
        factoryService.createEntityManager().remove(educationLevelEntity);
    }

    @Override
    public List<EducationLevelEntity> findByName(String name) {
        return factoryService.createEntityManager().createNamedQuery("EducationLevel.findByName").setParameter("name", name).getResultList();
    }

}
