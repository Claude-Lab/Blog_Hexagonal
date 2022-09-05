package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.factory.IUseCaseFactory;
import fr.lusseau.claude.application.usecase.*;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl
 * @date 29/08/2022
 */
@Named
@LogAudited
public class UseCaseFactoryImpl implements IUseCaseFactory {

    private final FactoryService factoryService;

    @Inject
    public UseCaseFactoryImpl(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public ICrudCompanyUseCase getCrudCompanyUseCase() {
        return new CrudCompanyUseCase(factoryService);
    }

    @Override
    public ICrudUserUseCase getCrudUserUseCase() {
        return new CrudUserUseCase(factoryService);
    }

    @Override
    public ICrudEducationLevelUseCase getCrudEducationLevelUseCase() {
        return new CrudEducationLevelUseCase(factoryService);
    }

    @Override
    public ICrudExperienceUseCase getCrudExperienceUseCase() {
        return new CrudExperienceUseCase(factoryService);
    }

    @Override
    public ICrudEducationUseCase getCrudEducationUseCase() {
        return new CrudEducationUseCase(factoryService);
    }

    @Override
    public ICheckUseCase getCheckUseCase() {
        return new CheckUseCase(factoryService);
    }



}
