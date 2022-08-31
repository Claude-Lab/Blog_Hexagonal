package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.domain.validator.UserValidator;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl
 * @date 29/08/2022
 */
@Named
@LogAudited
public class CrudUserUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudUserUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void create(User user) {
        UserDTO userDTO = IUserMapper.INSTANCE.userToUserDto(user);
        this.factoryService.getDaoFactory().getUserDao().persistAndFlush(userDTO);
    }

    public User getOne(Long id) {

        UserDTO userDTO = this.factoryService.getDaoFactory().getUserDao().findById(id);
        if (userDTO == null) {
            return null;
        }
        return IUserMapper.INSTANCE.userDtoToUser(userDTO);
    }


    public List<User> getAllUsers() {
        List<UserDTO> userDTOS = this.factoryService.getDaoFactory().getUserDao().listAll();
        if (userDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IUserMapper.INSTANCE.userDtoListToUserList(userDTOS);
    }

    public void update(User user) {
        User entity = getOne(user.getId());
        UserValidator.validateUser(user);
        UserDTO userDTO = IUserMapper.INSTANCE.userToUserDto(entity);
        this.factoryService.getDaoFactory().getUserDao().update(userDTO);
    }

    public void removeUser(User user) {
        this.factoryService.getDaoFactory().getUserDao().delete(IUserMapper.INSTANCE.userToUserDto(user));
    }
}
