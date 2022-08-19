package fr.lusseau.claude.infrastructure.factory;

import fr.lusseau.claude.application.factory.IDaoFactory;
import fr.lusseau.claude.application.factory.IUseCaseFactory;
import fr.lusseau.claude.domain.usecase.UseCaseFactoryImpl;
import fr.lusseau.claude.infrastructure.dao.factory.DaoFactoryImpl;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;


/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.factory
 * @date 13/08/2022
 */
@LogAudited
@RequestScoped
public class FactoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    public EntityManager createEntityManager() {
        return entityManager;
    }

    @Produces
    @Named
    public IDaoFactory createDaoFactory() {
        return new DaoFactoryImpl(this);
    }

    @Produces
    @Named
    public IUseCaseFactory createUseCaseFactory() {
        return new UseCaseFactoryImpl(this);
    }

}
