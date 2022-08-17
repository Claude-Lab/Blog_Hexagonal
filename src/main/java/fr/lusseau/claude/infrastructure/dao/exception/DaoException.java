package fr.lusseau.claude.infrastructure.dao.exception;

import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao.exception
 * @date 15/08/2022
 */
@LogAudited
public class DaoException extends RuntimeException {

    public DaoException() {
        super();
    }

    public DaoException(String s) {
        super(s);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
