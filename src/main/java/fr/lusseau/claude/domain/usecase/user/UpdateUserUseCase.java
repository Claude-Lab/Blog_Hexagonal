package fr.lusseau.claude.domain.usecase.user;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.domain.validator.UserValidator;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.user
 * @date 12/08/2022
 */
public class UpdateUserUseCase implements Serializable {

    private final FactoryService factoryService;

    @Inject
    public UpdateUserUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void updateUser(User user) {
        UserValidator.validateUser(user);
        UserDTO userDTO = IUserMapper.INSTANCE.userToUserDto(user);
        this.factoryService.createDaoFactory().getIUserDao().edit(userDTO);
    }


}
