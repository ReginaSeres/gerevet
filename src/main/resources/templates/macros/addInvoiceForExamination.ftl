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
        <table class="table table-striped table-hover">
            <tr>
                <td>
                    Csoport megnevezes
                </td>
                <td>
                    <span id="firstInvoiceGroup">0</span>
                </td>
            </tr>
        </table>
        <div>
            <table class="table table-striped table-hover" id="firstGroupElements"><tbody></tbody></table>
            <button class="btn btn-primary btn-xs" type="button" id="firstInvoiceGroupAdd">+</button>
        </div>
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