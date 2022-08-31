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
    void shouldGetCompanyInformation() {
        CompanyDTO article = CompanyDTO.builder()
                .withId(1L)
                .withName("test title")
                .withPlace("France")
                .withType("Laboratoire de test logiciel")
                .build();
        Assert.assertNotNull(article);
    }
}