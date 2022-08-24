package fr.lusseau.claude.application.usecase.user;

import fr.lusseau.claude.infrastructure.factory.FactoryService;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.usecase.user
 * @date 23/08/2022
 */
public class EmailCheckUseCase implements Serializable {

    private final FactoryService factoryService;

    @Inject
    public EmailCheckUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public Boolean isEmailExist(String email) {
        return this.factoryService.createDaoFactory().getIUserDao().isEmailExist(email);
    }

}
