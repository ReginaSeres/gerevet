package hu.jusoft.gerevet.view.model;

import hu.jusoft.gerevet.repository.model.InvoiceGroups;

import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class InvoicePageModel {
    private String id;
    private Date invoceDate;
    private Date paymentDeadline;
    private Date dayOfPayment;
    private List<InvoiceGroups> invoiceGroup;

    public InvoicePageModel(){}

    public InvoicePageModel(String id, Date invoceDate, Date paymentDeadline, Date dayOfPayment, List<InvoiceGroups> invoiceGroup) {
        this.id = id;
        this.invoceDate = invoceDate;
        this.paymentDeadline = paymentDeadline;
        this.dayOfPayment = dayOfPayment;
        this.invoiceGroup = invoiceGroup;
    }

    public String getId() {
        return id;
    }
    public Date getInvoceDate() {
        return invoceDate;
    }
    public Date getPaymentDeadline() {
        return  paymentDeadline;
    }
    public Date getDayOfPayment() {
        return dayOfPayment;
    }
    public List<InvoiceGroups> getInvoiceGroup() {
        return invoiceGroup;
    }
}
