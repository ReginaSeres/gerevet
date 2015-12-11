<#macro examinationDashBoard examination>

<div class="col-lg-4">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><a href="/examination/${examination.id}">${examination.invoice.id}</a></h3>
        </div>
        <div class="panel-body">
            <p>Páciens neve: <a href="/patient/${examination.patient.id}">${examination.patient.name}</a></p>
            <p>Állat neve: <a href="/animal/${examination.animal.id}">${examination.animal.name}</a>
            <p>Brutto osszar: ${examination.bruttoPrice}</p>
            <p class="text-right"><small>${examination.examinationDate?date}</small></p>
        </div>
    </div>
</div>

</#macro>