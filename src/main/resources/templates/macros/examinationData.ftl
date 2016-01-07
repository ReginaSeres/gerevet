<#macro examinationData examination>

<div class="col-lg-12 margin-top-for-tab">
    <p><strong><@label "examination.label.date" />: </strong> ${examination.examinationDate?date}</p>
</div>

<div class="col-lg-3 well well-sm">
    <strong><@label "examination.label.symptom" />: </strong>
    <p>${examination.symptom}</p>
</div>
<div class="col-lg-3 well well-sm">
    <strong><@label "examination.label.examination" />: </strong>
    <p>${examination.examination}</p>
</div>
<div class="col-lg-3 well well-sm">
    <strong><@label "examination.label.comment" />: </strong>
    <p>${examination.comment}</p>
</div>

<div class="col-lg-3">
    <p><strong><@label "examination.label.documents" />: </strong></p>
    <#list examination.documents as doc>
        <p><a href="/getFile/${doc.id}">${doc.name}</a></p>
    </#list>
</div>

</#macro>