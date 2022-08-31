package fr.lusseau.claude.domain.model;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.model
 * @date 11/08/2022
 */
class CompanyTest {

    @Test
    void shouldGetCompanyInformation() {
        Company company = Company.builder()
                .withId(1L)
                .withName("Kereval")
                .withType("Laboratoire de test logiciel")
                .withPlace("Rennes")
                .build();
        Assert.assertNotNull(company);
    }
}
