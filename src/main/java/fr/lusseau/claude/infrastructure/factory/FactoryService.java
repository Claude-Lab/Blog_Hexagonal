package fr.lusseau.claude.infrastructure.factory;

import fr.lusseau.claude.application.factory.IDaoFactory;
import fr.lusseau.claude.application.factory.IUseCaseFactory;
import fr.lusseau.claude.application.usecase.impl.UseCaseFactoryImpl;
import fr.lusseau.claude.infrastructure.dao.DaoFactoryImpl;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.enterprise.context.RequestScoped;
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
    private final EntityManager entityManager;

    public FactoryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Produces
    public EntityManager createEntityManager() {
        return entityManager;
    }


    @Produces
    public IUseCaseFactory getUseCaseFactory() {
        return new UseCaseFactoryImpl(this);
    }

    @Produces
    public IDaoFactory getDaoFactory() {
        return new DaoFactoryImpl(this);
    }
}
