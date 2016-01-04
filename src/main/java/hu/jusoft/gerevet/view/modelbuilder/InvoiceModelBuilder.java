package hu.jusoft.gerevet.view.modelbuilder;

import hu.jusoft.gerevet.repository.model.Invoice;
import hu.jusoft.gerevet.view.model.InvoicePageModel;
import org.springframework.stereotype.Component;

/**
 * Created by Regina Seres on 12/15/2015.
 */
@Component
public class InvoiceModelBuilder {

    public InvoicePageModel build(Invoice invoice) {
        return new InvoicePageModel(invoice.getInvoiceId(), invoice.getInvoceDate(), invoice.getPaymentDeadline(), invoice.getDayOfPayment());
    }
}
