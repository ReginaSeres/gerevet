<#macro addInvoiceForExamination>
    <div class="col-lg-6">
        <div class="col-lg-4">
            <strong><@label "invoice.label.invoice_date" />: </strong>
        </div>
        <div class="col-lg-6">
            <input type="text" id="datepicker" class="input-sm form-control date-picker-input datepicker" name="invoiceDate" />
        </div>

        <div class="col-lg-4">
            <strong><@label "invoice.label.invoice_number" />: </strong>
        </div>
        <div class="col-lg-6">
            <input type="number" min="0" class="form-control" id="invoiceId" name="invoiceId" />
        </div>

        <div class="col-lg-4">
            <strong><@label "invoice.label.payment_deadline" />: </strong>
        </div>
        <div class="col-lg-6">
            <input type="text" id="datepicker" class="input-sm form-control date-picker-input datepicker" name="invoicePaymentDeadline" />
        </div>

        <div class="col-lg-4">
            <strong><@label "invoice.label.day_of_payment" />: </strong>
        </div>
        <div class="col-lg-6">
            <input type="text" id="datepicker" class="input-sm form-control date-picker-input datepicker" name="invoiceDayOfPayment" />
        </div>
    </div>
    <div class="col-lg-6">
        <#list invoiceGroups as group>
            <#assign i = group_index>
            <#assign groupname = "invoiceGroups[${i}]" >
            <div class="table-container">
                <table class="table table-striped table-hover">
                    <tr class="info">
                        <td>
                            <button class="btn btn-primary btn-xs show-children" type="button">+</button>
                            <button class="btn btn-primary btn-xs hide-children hidden" type="button">-</button>
                            <span>${group}</span>
                            <input type="hidden" name="${groupname}.name" value="${group}"/>
                        </td>
                        <td class="text-right">
                            <span class="invoice-group-amount">0</span>
                            <input type="hidden" name="${groupname}.netPrice" class="invoice-group-amount-hidden" value="0"/>
                        </td>
                    </tr>
                </table>
                <div class="group-items hidden">
                    <table class="table table-striped table-hover" id="firstGroupElements"><tbody></tbody></table>
                    <button class="btn btn-primary btn-xs add-invoice-element" type="button" data-groupname=${groupname}>+</button>
                </div>
            </div>
        </#list>
    </div>
    <div class="col-lg-12">
        <div class="col-lg-10">
        </div>
        <div class="col-lg-1">
            <span><strong>SUM</strong></span>
        </div>
        <div class="col-lg-1 text-right">
            <span id="netSum">0</span>
        </div>
    </div>
</#macro>