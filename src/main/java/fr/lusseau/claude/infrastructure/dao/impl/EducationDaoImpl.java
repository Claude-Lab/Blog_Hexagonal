package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.dto.EducationDTO;
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
public class EducationDaoImpl implements PanacheRepository<EducationDTO> {

    private final FactoryService factoryService;

    @Inject
    public EducationDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(EducationDTO educationDTO) {
        factoryService.createEntityManager().merge(educationDTO);
    }

    public EducationDTO isTitleExist(String title) {
        return find("title",title).firstResult();
    }

    public EducationDTO isUrlExist(String url) {
        return find("url",url).firstResult();
    }
}