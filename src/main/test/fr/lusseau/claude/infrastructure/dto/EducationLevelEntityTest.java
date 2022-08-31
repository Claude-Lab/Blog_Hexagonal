package fr.lusseau.claude.infrastructure.dto;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.entity
 * @date 11/08/2022
 */
class EducationLevelEntityTest {

    @Test
    void shouldGetEducationLevelInformation() {
        EducationLevelDTO article = EducationLevelDTO.builder()
                .withId(1L)
                .withName("Master degree")
                .build();
        Assert.assertNotNull(article);
    }
}