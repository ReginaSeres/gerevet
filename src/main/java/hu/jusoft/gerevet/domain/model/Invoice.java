package hu.jusoft.gerevet.domain.model;

import java.util.Date;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class Invoice {
    private String id;
    private Date invoceDate;
    private int invoceNumber;
    private Date paymentDeadline;
    private Date dayOfPayment;

    private String getId() {
        return id;
    }
    private void setId(String id) {
        this.id = id;
    }
    private Date getInvoceDate() {
        return invoceDate;
    }
    private void setInvoceDate(Date invoceDate) {
        this.invoceDate = invoceDate;
    }
    private int getInvoceNumber() {
        return invoceNumber;
    }
    private void setInvoceNumber(int invoceNumber) {
        this.invoceNumber = invoceNumber;
    }
    private Date getPaymentDeadline() {
        return  paymentDeadline;
    }
    private void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }
    private Date getDayOfPayment() {
        return dayOfPayment;
    }
    private void setDayOfPayment(Date dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
    }
}
