package fr.lusseau.claude.domain.model;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.model
 * @date 11/08/2022
 */
class EducationTest {

    @Test
    void shouldGetEducationArticleInformation() {
        Education education = Education.builder().build();
        Assert.assertNotNull(education);
    }
}
