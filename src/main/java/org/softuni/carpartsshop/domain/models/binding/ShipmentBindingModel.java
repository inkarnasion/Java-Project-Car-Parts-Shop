package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ShipmentBindingModel {
    private BigDecimal shipmentPrice;
    private String shipmentAddress;

    public ShipmentBindingModel() {
    }
    @NotNull
    @DecimalMin("0.01")
    public BigDecimal getShipmentPrice() {
        return this.shipmentPrice;
    }

    public void setShipmentPrice(BigDecimal shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }
    @NotNull(message = "Name cannot be null")
    @NotEmpty
    @Length(min = 2, message = "UserName must be at least 2 characters long.")
    @Length(max = 20, message = "UserName must be maximum 20 characters long.")
    public String getShipmentAddress() {
        return this.shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }
}
