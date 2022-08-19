package fr.lusseau.claude.infrastructure.dto;

import fr.lusseau.claude.domain.model.Role;
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
        UserDTO article = UserDTO.builder()
                .withId(2L)
                .withEmail("test@test.test")
                .withFirstName("John")
                .withLastName("Doe")
                .withPassword("lost")
                .withRole(Role.ADMINISTRATOR)
                .build();
        Assert.assertNotNull(article);
    }
}