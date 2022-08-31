package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.entity.EducationEntity;
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
 * @date 15/08/2022
 */
@Named("EducationDaoImpl")
@LogAudited
@ApplicationScoped
public class EducationDaoImpl implements PanacheRepository<EducationEntity> {

    private final FactoryService factoryService;

    @Inject
    public EducationDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(EducationEntity educationDTO) {
        factoryService.createEntityManager().merge(educationDTO);
    }

    public EducationEntity isTitleExist(String title) {
        return find("title",title).firstResult();
    }

    public EducationEntity isUrlExist(String url) {
        return find("url",url).firstResult();
    }
}