package fr.lusseau.claude.application.factory;

import fr.lusseau.claude.application.usecase.user.*;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.factory
 * @date 17/08/2022
 */
public interface IUseCaseFactory {

    GetUserUseCase getUserUseCase();

    DeleteUserUseCase deleteUserUseCase();

    CreateUserUseCase createUserUseCase();

    UpdateUserUseCase updateUserUseCase();

    EmailCheckUseCase emailCheckUseCase();
}
