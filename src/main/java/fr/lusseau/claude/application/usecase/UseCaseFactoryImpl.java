package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.application.factory.IUseCaseFactory;
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
    public CrudCompanyUseCase getCrudCompanyUseCase() {
        return new CrudCompanyUseCase(factoryService);
    }

    @Override
    public CrudUserUseCase getCrudUserUseCase() {
        return new CrudUserUseCase(factoryService);
    }

    @Override
    public CrudEducationLevelUseCase getCrudEducationLevelUseCase() {
        return new CrudEducationLevelUseCase(factoryService);
    }

    @Override
    public CrudExperienceUseCase getCrudExperienceUseCase() {
        return new CrudExperienceUseCase(factoryService);
    }

    @Override
    public CrudEducationUseCase getCrudEducationUseCase() {
        return new CrudEducationUseCase(factoryService);
    }

    @Override
    public CheckUseCase getCheckUseCase() {
        return new CheckUseCase(factoryService);
    }



}
