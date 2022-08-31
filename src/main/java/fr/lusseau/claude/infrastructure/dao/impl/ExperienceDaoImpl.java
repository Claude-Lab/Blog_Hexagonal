package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.dto.ExperienceDTO;
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
public class ExperienceDaoImpl implements PanacheRepository<ExperienceDTO>  {

    private final FactoryService factoryService;

    @Inject
    public ExperienceDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(ExperienceDTO experienceDTO) {
        factoryService.createEntityManager().merge(experienceDTO);
    }

    public ExperienceDTO isTitleExist(String title) {
        return find("title", title).firstResult();
    }

    public ExperienceDTO isUrlExist(String url) {
        return find("url", url).firstResult();
    }


}
