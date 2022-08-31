package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.dto.EducationLevelDTO;
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
public class EducationLevelDaoImpl implements PanacheRepository<EducationLevelDTO> {


    private final FactoryService factoryService;

    @Inject
    public EducationLevelDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(EducationLevelDTO educationLevelDTO) {
        factoryService.createEntityManager().merge(educationLevelDTO);
    }

    public EducationLevelDTO isNameExist(String name) {
        return find("name", name).firstResult();
    }
}
