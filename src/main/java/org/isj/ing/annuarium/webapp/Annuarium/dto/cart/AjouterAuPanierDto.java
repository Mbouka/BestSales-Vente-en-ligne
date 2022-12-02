package org.isj.ing.annuarium.webapp.Annuarium.dto.cart;

import javax.validation.constraints.NotNull;

public class AjouterAuPanierDto {

    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
