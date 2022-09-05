package fr.lusseau.claude.infrastructure.entity;

import fr.lusseau.claude.domain.model.Role;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import java.time.LocalDateTime;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.entity
 * @date 11/08/2022
 */
class ExperienceEntityTest {

    @Test
    void shouldGetExperienceInformation() {
        ExperienceEntity article = ExperienceEntity.builder()
                .withId(1L)
                .withTitle("test title")
                .withBody("Body test")
                .withUrl("test url")
                .withCreatedAt(LocalDateTime.now())
                .withDateIn(LocalDateTime.of(2011,12, 03,00,00))
                .withAuthor(UserEntity.builder()
                        .withId(2L)
                        .withEmail("test@test.test")
                        .withFirstName("John")
                        .withLastName("Doe")
                        .withPassword("lost")
                        .withRole(Role.ADMINISTRATOR)
                        .build())
                .build();
        Assert.assertNotNull(article);
    }
}