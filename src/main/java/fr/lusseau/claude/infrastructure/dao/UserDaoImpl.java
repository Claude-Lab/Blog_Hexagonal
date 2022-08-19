package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.dao.IUserDao;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;
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
    public UserDaoImpl(FactoryService factory) {
        this.factoryService = factory;
    }

    @Override
    public Boolean create(UserDTO userDTO) {
        this.factoryService.createEntityManager().persist(userDTO);
        return userDTO.getId() != null;
    }

    @Override
    public UserDTO edit(UserDTO userDTO) {
        this.factoryService.createEntityManager().merge(userDTO);
        this.factoryService.createEntityManager().flush();
        return userDTO;
    }

    @Override
    public void remove(Long id) {
        UserDTO userDTO = this.factoryService.createDaoFactory().getIUserDao().findUser(id);
        this.factoryService.createEntityManager().remove(userDTO);
    }

    @Override
    public UserDTO findUser(Long id) {
        return this.factoryService.createEntityManager().find(UserDTO.class, id);
    }

    @Override
    public List<UserDTO> findAll() {
        Query query = this.factoryService.createEntityManager().createNamedQuery("User.findAll", UserDTO.class);
        return query.getResultList();
    }

}