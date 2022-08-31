package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.infrastructure.entity.UserEntity;
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
 * @date 14/08/2022
 */
@Named("UserDaoImpl")
@LogAudited
@ApplicationScoped
public class UserDaoImpl implements PanacheRepository<UserEntity> {

    private final FactoryService factoryService;

    @Inject
    public UserDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void update(UserEntity userEntity) {
        factoryService.createEntityManager().merge(userEntity);
    }

    public UserEntity isEmailExist(String email) {
        return find("email",email).firstResult();
    }

}