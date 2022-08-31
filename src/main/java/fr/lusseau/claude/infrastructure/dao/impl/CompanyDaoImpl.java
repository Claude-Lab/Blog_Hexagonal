package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.dto.CompanyDTO;
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
@Named("CompanyDaoImpl")
@LogAudited
@ApplicationScoped
public class CompanyDaoImpl implements PanacheRepository<CompanyDTO> {

    private final FactoryService factoryService;

    @Inject
    public CompanyDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }


    public CompanyDTO isNameExist(String name) {
        return find("name", name).firstResult();
    }

}
