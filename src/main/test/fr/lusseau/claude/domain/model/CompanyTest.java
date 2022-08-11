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
        Company company = Company.builder().build();
        Assert.assertNotNull(company);
    }
}
