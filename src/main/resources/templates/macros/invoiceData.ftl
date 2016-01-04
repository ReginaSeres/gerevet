<#macro invoiceData invoice>
    <div class="col-lg-6">
        <p><strong><@label "invoice.label.invoice_date" />: </strong>${invoice.invoceDate?date}</p>
        <p><strong><@label "invoice.label.invoice_number" />: </strong>${invoice.id}</p>
        <p><strong><@label "invoice.label.payment_deadline" />: </strong>${invoice.paymentDeadline?date}</p>
        <p><strong><@label "invoice.label.day_of_payment" />: </strong>${invoice.dayOfPayment?date}</p>
    </div>
    <div class="col-lg-6">
        TODO:
    </div>
</#macro>