<#macro patientDashBoard patient>

<div class="col-lg-4">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><a href="/patient/${patient.id}">${patient.name}</a></h3>
        </div>
        <div class="panel-body">
            <#if patient.city?? && patient.city!=""><p><strong>Város:</strong> ${patient.city}</p></#if>
            <#if patient.address?? && patient.address!=""><p><strong>Cím:</strong> ${patient.address}</p></#if>
            <#if patient.phoneNumber?? && patient.phoneNumber!=""><p><strong>Telefon:</strong> ${patient.phoneNumber}</p></#if>
            <#if patient.emailAddress?? && patient.emailAddress!=""><p><strong>Email:</strong> ${patient.emailAddress}</p></#if>
        </div>
    </div>
</div>

</#macro>