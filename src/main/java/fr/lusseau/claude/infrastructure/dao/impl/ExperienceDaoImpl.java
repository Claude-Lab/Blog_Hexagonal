package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.entity.ExperienceEntity;
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
@Named("ExperienceDaoImpl")
@LogAudited
@ApplicationScoped
public class ExperienceDaoImpl implements PanacheRepository<ExperienceEntity>  {

    private final FactoryService factoryService;

    @Inject
    public ExperienceDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(ExperienceEntity experienceDTO) {
        factoryService.createEntityManager().merge(experienceDTO);
    }

    public ExperienceEntity isTitleExist(String title) {
        return find("title", title).firstResult();
    }

    public ExperienceEntity isUrlExist(String url) {
        return find("url", url).firstResult();
    }


}
