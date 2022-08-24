package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.application.factory.IUseCaseFactory;
import fr.lusseau.claude.application.usecase.user.*;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.usecase
 * @date 17/08/2022
 */
@LogAudited
@Named("UseCaseFactoryImpl")
public class UseCaseFactoryImpl implements IUseCaseFactory {

    private final FactoryService factoryService;

    @Inject
    public UseCaseFactoryImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public GetUserUseCase getUserUseCase() {
        return new GetUserUseCase(factoryService);
    }

    @Override
    public DeleteUserUseCase deleteUserUseCase() {
        return new DeleteUserUseCase(factoryService);
    }

    @Override
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCase(factoryService);
    }

    @Override
    public UpdateUserUseCase updateUserUseCase() {
        return new UpdateUserUseCase(factoryService);
    }

    @Override
    public EmailCheckUseCase emailCheckUseCase() {
        return new EmailCheckUseCase(factoryService);
    }
}
