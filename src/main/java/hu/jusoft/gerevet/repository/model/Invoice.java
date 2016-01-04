package hu.jusoft.gerevet.repository.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public class Invoice {
    private String invoiceId;
    private Date invoceDate;
    private Date paymentDeadline;
    private Date dayOfPayment;
    private List<InvoiceGroups> invoiceGroup;

    public  String getInvoiceId() {
        return invoiceId;
    }
    public Date getInvoceDate() {
        return invoceDate;
    }
    public Date getPaymentDeadline() {
        return paymentDeadline;
    }
    public Date getDayOfPayment() {
        return dayOfPayment;
    }
    public List<InvoiceGroups> getInvoiceGroup() {
        return invoiceGroup;
    }
}
