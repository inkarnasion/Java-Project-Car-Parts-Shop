package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;

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
    @NotNull(message = Constant.NAME_CANNOT_BE_NULL)
    @NotEmpty
    @Length(min = 2, message = Constant.ADDRESSES_MUST_BE_ATLEAST_2_CHARACTER_LONG)
    @Length(max = 100, message = Constant.ADDRESSES_MUST_BE_MAXIMUM_100_CHARACTER_LONG)
    public String getShipmentAddress() {
        return this.shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }
}
