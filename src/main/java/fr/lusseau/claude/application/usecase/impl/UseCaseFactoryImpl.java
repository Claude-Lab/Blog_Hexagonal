package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.factory.IUseCaseFactory;
import fr.lusseau.claude.application.usecase.ICheckUseCase;
import fr.lusseau.claude.application.usecase.check.CheckUseCase;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 08/09/2022
 */
@LogAudited
@Named
public class UseCaseFactoryImpl implements IUseCaseFactory {

    private final FactoryService factoryService;

    @Inject
    public UseCaseFactoryImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public ICheckUseCase getCheckUseCase() {
        return new CheckUseCase(factoryService);
    }
}
