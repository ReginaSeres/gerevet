<#macro invoiceData invoice examinationId>
    <div class="col-lg-6 margin-top-for-tab">
        <p><strong><@label "invoice.label.invoice_date" />: </strong>${invoice.invoceDate?date}</p>
        <p><strong><@label "invoice.label.invoice_number" />: </strong>${invoice.id}</p>
        <p><strong><@label "invoice.label.payment_deadline" />: </strong>${invoice.paymentDeadline?date}</p>
        <p><strong><@label "invoice.label.day_of_payment" />: </strong>${invoice.dayOfPayment?date}</p>
        <a href="/getInvoice/${examinationId}" target="_blank" class="btn btn-primary">Print</a>
    </div>
    <div class="col-lg-6 margin-top-for-tab">
        <table class="table table-striped table-hover "
            <tbody>
                <#list invoice.invoiceGroup as group>
                    <tr class="info">
                        <td><strong>
                            ${group.name}
                        </strong></td>
                        <td><strong>
                            ${group.netPrice}
                        </strong></td>
                    </tr>
                    <#if group.items??>
                        <#list group.items as item>
                            <tr>
                                <td>
                                    <span style="margin-left: 5px">${item.description}</span>
                                </td>
                                <td>
                                    <span>${item.price}</span>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                </#list>
            </tbody>
        </table>
    </div>
</#macro>