<#macro invoiceData invoice>
    <div class="col-lg-6">
        <p><strong>Számla dátuma: </strong>${invoice.invoceDate?date}</p>
        <p><strong>Számla szám: </strong>${invoice.id}</p>
        <p><strong>Fizetési határidő: </strong>${invoice.paymentDeadline?date}</p>
        <p><strong>Fizetés dátuma: </strong>${invoice.dayOfPayment?date}</p>
    </div>
    <div class="col-lg-6">
        TODO:
    </div>
</#macro>