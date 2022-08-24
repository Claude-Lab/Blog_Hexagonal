package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.domain.model.Role;
import fr.lusseau.claude.infrastructure.dto.UserDTO;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.transaction.annotations.Rollback;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.wildfly.common.Assert.assertTrue;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 14/08/2022
 */
@QuarkusTest
@Rollback
@TestTransaction
class UserDaoImplTest {

    private final FactoryService factoryService;

    @Inject
    public UserDaoImplTest(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @Test
    void createUser() {
        UserDTO user = UserDTO.builder()
                .withEmail("john.doe@lost.com")
                .withFirstName("John")
                .withLastName("Doe")
                .withPassword("what")
                .withRole(Role.SUBSCRIBER).build();
        this.factoryService.createDaoFactory().getIUserDao().create(user);

    }

    @Test
    void editUser() {
        UserDTO user = UserDTO.builder()
                .withId(12L)
                .withEmail("john.doe@lost.com")
                .withFirstName("John")
                .withLastName("Doe")
                .withPassword("what")
                .withRole(Role.SUBSCRIBER).build();
        this.factoryService.createDaoFactory().getIUserDao().edit(user);
        Assertions.assertThat(user).isNotNull();
    }
}
