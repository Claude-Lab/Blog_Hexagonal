package fr.lusseau.claude.infrastructure.resource.exception;

import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import java.io.Serializable;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.resource.exception
 * @date 22/08/2022
 */
public class ResourceException extends RuntimeException implements Serializable {

    public ResourceException() {
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }

    public ResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}