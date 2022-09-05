package fr.lusseau.claude.infrastructure.dao.impl;

import fr.lusseau.claude.application.dao.IUserDao;
import fr.lusseau.claude.infrastructure.entity.UserEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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
    public UserDaoImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public List<UserEntity> getAll() {
        return factoryService.createEntityManager().createQuery("FROM UserEntity").getResultList();
    }

    @Override
    public UserEntity getOne(Long id) {
        return factoryService.createEntityManager().find(UserEntity.class, id);
    }

    @Override
    public void create(UserEntity userEntity) {
        factoryService.createEntityManager().persist(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        factoryService.createEntityManager().merge(userEntity);
    }

    @Override
    public void remove(UserEntity userEntity) {
        userEntity = getOne(userEntity.getId());
        factoryService.createEntityManager().remove(userEntity);
    }

    @Override
    public List<UserEntity> isEmailExist(String email) {
        return factoryService.createEntityManager().createNamedQuery("User.isEmailExist").setParameter("email", email).getResultList();
    }
}