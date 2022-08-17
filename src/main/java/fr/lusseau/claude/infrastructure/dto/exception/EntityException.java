package fr.lusseau.claude.infrastructure.dto.exception;

import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.exception
 * @date 06/08/2022
 */
@LogAudited
public class EntityException extends RuntimeException {

    public EntityException() {
        super();
    }

    public EntityException(String s) {
        super(s);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityException(Throwable cause) {
        super(cause);
    }
}
