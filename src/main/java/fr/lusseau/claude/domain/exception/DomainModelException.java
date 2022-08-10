package fr.lusseau.claude.domain.exception;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.exception
 * @date 06/08/2022
 */
public class DomainModelException extends RuntimeException {

    public DomainModelException() {
        super();
    }

    public DomainModelException(String s) {
        super(s);
    }

    public DomainModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainModelException(Throwable cause) {
        super(cause);
    }
}
