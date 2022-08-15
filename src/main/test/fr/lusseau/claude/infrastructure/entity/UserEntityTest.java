package fr.lusseau.claude.infrastructure.entity;

import fr.lusseau.claude.infrastructure.entity.RoleEntity;
import fr.lusseau.claude.infrastructure.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.entity
 * @date 11/08/2022
 */
class UserEntityTest {

    @Test
    void shouldGetArticleInformation() {
        UserEntity article = UserEntity.builder()
                .withId(2L)
                .withEmail("test@test.test")
                .withFirstname("John")
                .withLastname("Doe")
                .withPassword("lost")
                .withRole(RoleEntity.ADMINISTRATOR)
                .build();
        Assert.assertNotNull(article);
    }
}