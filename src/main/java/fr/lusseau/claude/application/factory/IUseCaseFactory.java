package fr.lusseau.claude.application.factory;

import fr.lusseau.claude.domain.usecase.user.CreateUserUseCase;
import fr.lusseau.claude.domain.usecase.user.DeleteUserUseCase;
import fr.lusseau.claude.domain.usecase.user.GetUserUseCase;
import fr.lusseau.claude.domain.usecase.user.UpdateUserUseCase;

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
}
