package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 27/08/2022
 */
@LogAudited
@Named("EducationLevelDaoImpl")
@ApplicationScoped
public class EducationLevelDaoImpl implements PanacheRepository<EducationLevelEntity> {


    private final FactoryService factoryService;

    @Inject
    public EducationLevelDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(EducationLevelEntity educationLevelEntity) {
        factoryService.createEntityManager().merge(educationLevelEntity);
    }

    public EducationLevelEntity isNameExist(String name) {
        return find("name", name).firstResult();
    }
}
