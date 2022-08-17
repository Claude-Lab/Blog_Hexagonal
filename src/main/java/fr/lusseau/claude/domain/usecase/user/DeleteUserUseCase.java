package fr.lusseau.claude.domain.usecase.user;

import fr.lusseau.claude.domain.model.User;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.mapper.IUserMapper;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.user
 * @date 12/08/2022
 */
@LogAudited
@Named("DeleteUserUseCase")
public class DeleteUserUseCase implements Serializable {

    private final FactoryService factoryService;

    @Inject
    private IUserMapper userMapper;

    @Inject
    public DeleteUserUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public Integer removeUser(Long id) {
        if (factoryService.createUseCaseFactory().getUserUseCase().getOne(id) == null) {
            return null;
        }
        return this.factoryService.createDaoFactory().getIUserDao().remove(id);
    }
}
