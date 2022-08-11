package fr.lusseau.claude.application.entity;

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
    void shouldGetArticleInformation() {
        EducationLevelEntity article = EducationLevelEntity.builder()
                .withId(1L)
                .withTitle("Master degree")
                .build();
        Assert.assertNotNull(article);
    }
}