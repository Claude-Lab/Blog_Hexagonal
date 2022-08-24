package fr.lusseau.claude.infrastructure.resource.exception;

import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.resource.exception
 * @date 22/08/2022
 */
@LogAudited
public class ErrorMessage {

    private String message;
    private Boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

	public ErrorMessage(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public ErrorMessage() {
		super();
	}

}