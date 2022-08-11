package fr.lusseau.claude.application.entity;


/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.entity
 * @date 06/08/2022
 */

public enum RoleEntity {

    SUBSCRIBER,         // Just can see hidden page.
    CONTRIBUTOR,        // Can write articles, but has no control over publication.
    AUTHOR,             // Can publish articles and does not need an approval to put them online.
    EDITOR,             // Has control over everything related to editorial. He can publish pages, articles, but also modify and delete them, even if they have been created by other users.
    ADMINISTRATOR       // All.
}
