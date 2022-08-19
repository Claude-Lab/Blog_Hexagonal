package fr.lusseau.claude.domain.usecase.user;

import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.enterprise.context.RequestScoped;
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
@RequestScoped
public class DeleteUserUseCase implements Serializable {

    private final FactoryService factoryService;


    @Inject
    public DeleteUserUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public Boolean removeUser(Long id) {
        if (this.factoryService.createUseCaseFactory().getUserUseCase().getOne(id) == null) {
            return false;
        }
        this.factoryService.createDaoFactory().getIUserDao().remove(id);
        return this.factoryService.createUseCaseFactory().getUserUseCase().getOne(id) == null;
    }
}
