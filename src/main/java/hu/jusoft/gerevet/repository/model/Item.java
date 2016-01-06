package hu.jusoft.gerevet.repository.model;

import java.math.BigDecimal;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public class Item {
    private String description;
    private BigDecimal price;

    public String getDescription() {
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
