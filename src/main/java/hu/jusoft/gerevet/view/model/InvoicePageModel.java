package hu.jusoft.gerevet.view.model;

import java.util.Date;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class InvoicePageModel {
    private String id;
    private Date invoceDate;
    private Date paymentDeadline;
    private Date dayOfPayment;

    public InvoicePageModel(){}

    public InvoicePageModel(String id, Date invoceDate, Date paymentDeadline, Date dayOfPayment) {
        this.id = id;
        this.invoceDate = invoceDate;
        this.paymentDeadline = paymentDeadline;
        this.dayOfPayment = dayOfPayment;
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
}
