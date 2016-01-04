<#macro examinationDashBoard examination>

<div class="col-lg-4">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><a href="/examination/${examination.id}">${examination.invoice.id}</a></h3>
        </div>
        <div class="panel-body">
            <p><@label "examination.label.patient_name" />: <a href="/patient/${examination.patient.id}">${examination.patient.name}</a></p>
            <p><@label "examination.label.animal_name" />: <a href="/animal/${examination.patient.id}-${examination.animal.id}">${examination.animal.name}</a>
            <p><@label "examination.label.brutto_price" />: ${examination.bruttoPrice}</p>
            <p class="text-right"><small>${examination.examinationDate?date}</small></p>
        </div>
    </div>
</div>

</#macro>