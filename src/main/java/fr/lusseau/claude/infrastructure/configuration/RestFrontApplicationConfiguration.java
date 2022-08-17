package fr.lusseau.claude.infrastructure.configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.configuration
 * @date 17/08/2022
 */
@ApplicationPath("/rest/front/api/v1")
public class RestFrontApplicationConfiguration extends Application {
    // Always empty.
}