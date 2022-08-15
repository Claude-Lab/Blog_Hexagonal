package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IUserDao;
import fr.lusseau.claude.infrastructure.entity.UserEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

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
public class UserDaoImpl implements IUserDao {

    private final FactoryService factoryService;

    @Inject
    public UserDaoImpl(FactoryService factory) {
        this.factoryService = factory;
    }

    @Override
    public Long create(UserEntity user) {
        factoryService.createEntityManager().persist(user);
        factoryService.createEntityManager().flush();
        return user.getId();
    }

    @Override
    public Long edit(UserEntity user) {
        factoryService.createEntityManager().merge(user);
        factoryService.createEntityManager().flush();
        return user.getId();
    }

    @Override
    public Boolean remove(UserEntity user) {
        factoryService.createEntityManager().remove(user);
        factoryService.createEntityManager().flush();
        return user == null;
    }

    @Override
    public UserEntity findUser(Long id) {
        return factoryService.createEntityManager().find(UserEntity.class, id);
    }


}