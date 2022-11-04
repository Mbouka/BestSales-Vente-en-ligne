package org.isj.ing.annuarium.webapp.Annuarium.error;

import lombok.Getter;
import org.zalando.problem.Status;

@Getter
public enum ErrorInfo {
    REFERENCE_RESSOURCE_REQUIRED("#REFERENCE_RESSOURCE_REQUIRED", Status.BAD_REQUEST),
    RESSOURCE_NOT_FOUND("#RESSOURCE_NOT_FOUND", Status.NOT_FOUND),
    REFERENCE_RESSOURCE_ALREADY_USED("#REFERENCE_RESSOURCE_ALREADY_USED", Status.BAD_REQUEST),
    CATEGORIE_NOT_FOUND("#CATEGORIE_NOT_FOUND", Status.NOT_FOUND),
    PRODUIT_NOT_FOUND("#PRODUIT_NOT_FOUND", Status.NOT_FOUND),
    VENDEUR_NOT_FOUND("#VENDEUR_NOT_FOUND", Status.NOT_FOUND);

    private final String message;
    private final Status httpStatus;

    ErrorInfo(String message, Status httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
