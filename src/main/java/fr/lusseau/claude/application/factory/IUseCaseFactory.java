package fr.lusseau.claude.application.factory;

import fr.lusseau.claude.application.usecase.ICheckUseCase;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.factory
 * @date 08/09/2022
 */
public interface IUseCaseFactory {

    ICheckUseCase getCheckUseCase();
}
