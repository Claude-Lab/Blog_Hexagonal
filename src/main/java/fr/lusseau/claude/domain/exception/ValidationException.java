package fr.lusseau.claude.domain.exception;

import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.exception
 * @date 17/08/2022
 */
@LogAudited
public class ValidationException extends RuntimeException {

    public ValidationException() {
        super();
    }

    public ValidationException(String s) {
        super(s);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
