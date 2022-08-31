package fr.lusseau.claude.application.factory;


import fr.lusseau.claude.application.usecase.*;

import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 29/08/2022
 */
public interface IUseCaseFactory {

    @Named
    CrudCompanyUseCase getCrudCompanyUseCase();
    @Named
    CrudUserUseCase getCrudUserUseCase();
    @Named
    CrudEducationLevelUseCase getCrudEducationLevelUseCase();
    @Named
    CrudExperienceUseCase getCrudExperienceUseCase();
    @Named
    CrudEducationUseCase getCrudEducationUseCase();
    @Named
    CheckUseCase getCheckUseCase();

}
