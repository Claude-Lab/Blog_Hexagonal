package fr.lusseau.claude.application.exception;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.exception
 * @date 06/08/2022
 */
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
