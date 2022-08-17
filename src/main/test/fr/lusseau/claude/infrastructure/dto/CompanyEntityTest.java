package fr.lusseau.claude.infrastructure.dto;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.entity
 * @date 11/08/2022
 */
class CompanyEntityTest {

    @Test
    void shouldGetArticleInformation() {
        CompanyDTO article = CompanyDTO.builder()
                .withId(1L)
                .withName("test title")
                .withUrl("test url")
                .withPlace("France")
                .build();
        Assert.assertNotNull(article);
    }
}