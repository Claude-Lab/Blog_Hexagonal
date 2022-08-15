package fr.lusseau.claude.infrastructure.entity;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import java.time.LocalDateTime;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.entity
 * @date 11/08/2022
 */
class EducationEntityTest {

    @Test
    void shouldGetEducationInformation() {
        EducationEntity article = EducationEntity.builder()
                .withTitle("test title")
                .withBody("Body test")
                .withUrl("test url")
                .withDateIn(LocalDateTime.of(2022,12,25,12,00,00))
                .withCreatedAt(LocalDateTime.now())
                .withAuthor(UserEntity.builder()
                        .withId(2L)
                        .withEmail("test@test.test")
                        .withFirstname("John")
                        .withLastname("Doe")
                        .withPassword("lost")
                        .withRole(RoleEntity.SUBSCRIBER)
                        .build())
                .build();
        Assert.assertNotNull(article);
    }
}