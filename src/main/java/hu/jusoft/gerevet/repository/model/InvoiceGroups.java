package hu.jusoft.gerevet.repository.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public class InvoiceGroups {
    private String name;
    private BigDecimal netPrice;
    private List<Item> items;

    public String getName() {
        return name;
    }
    public List<Item> getItems() {
        return items;
    }
    public BigDecimal getNetPrice() {
        return netPrice;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
