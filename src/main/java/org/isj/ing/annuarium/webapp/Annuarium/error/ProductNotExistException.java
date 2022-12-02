package org.isj.ing.annuarium.webapp.Annuarium.error;

public class ProductNotExistException extends IllegalArgumentException {
    public ProductNotExistException(String msg) {
        super(msg);
    }
}
