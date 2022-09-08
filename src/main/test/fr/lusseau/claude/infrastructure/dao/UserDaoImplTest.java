package fr.lusseau.claude.infrastructure.dao;

import fr.lusseau.claude.application.factory.IAbstractCrudDaoFactory;
import fr.lusseau.claude.domain.model.Role;
import fr.lusseau.claude.infrastructure.entity.UserEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.transaction.annotations.Rollback;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

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

    private final IAbstractCrudDaoFactory<UserEntity> crudDaoFactory;

    @Inject
    public UserDaoImplTest(IAbstractCrudDaoFactory<UserEntity> crudDaoFactory) {
        this.crudDaoFactory = crudDaoFactory;
    }

    @Test
    void createUser() {
        UserEntity user = UserEntity.builder()
                .withEmail("john.doe@lost.com")
                .withFirstName("John")
                .withLastName("Doe")
                .withPassword("what")
                .withRole(Role.SUBSCRIBER).build();
        crudDaoFactory.create(user);

    }

    @Test
    void editUser() {
        UserEntity user = UserEntity.builder()
                .withId(12L)
                .withEmail("john.doe@lost.com")
                .withFirstName("John")
                .withLastName("Doe")
                .withPassword("what")
                .withRole(Role.SUBSCRIBER).build();
        crudDaoFactory.update(user);
        Assertions.assertThat(user).isNotNull();
    }
}
