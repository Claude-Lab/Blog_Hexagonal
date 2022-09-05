package fr.lusseau.claude.application.factory;


import fr.lusseau.claude.application.usecase.*;
import fr.lusseau.claude.application.usecase.impl.*;

import javax.inject.Named;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 29/08/2022
 */
public interface IUseCaseFactory {


    ICrudCompanyUseCase getCrudCompanyUseCase();

    ICrudUserUseCase getCrudUserUseCase();

    ICrudEducationLevelUseCase getCrudEducationLevelUseCase();

    ICrudExperienceUseCase getCrudExperienceUseCase();

    ICrudEducationUseCase getCrudEducationUseCase();

    ICheckUseCase getCheckUseCase();

}
