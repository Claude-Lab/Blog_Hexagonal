package fr.lusseau.claude.application.usecase.user;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.user
 * @date 12/08/2022
 */
@LogAudited
@Named
public class GetUserUseCase implements Serializable {

    private final FactoryService factoryService;

    @Inject
    public GetUserUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }


    public User getOne(Long id) {

        UserDTO userDTO = this.factoryService.createDaoFactory().getIUserDao().findUser(id);
        if (userDTO == null) {
            return null;
        }
        return IUserMapper.INSTANCE.userDtoToUser(userDTO);
    }


    public List<User> getAllUsers() {
        List<UserDTO> userDTOS = this.factoryService.createDaoFactory().getIUserDao().findAll();
        if (userDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return IUserMapper.INSTANCE.userDtoListToUserList(userDTOS);
    }

}
