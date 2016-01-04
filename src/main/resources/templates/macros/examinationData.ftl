<#macro examinationData examination>

<div class="col-lg-12">
    <p><strong><@label "examination.label.date" />: </strong> ${examination.examinationDate?date}</p>
    TODO: Documentations
</div>
<div class="col-lg-12">
    <div class="col-lg-1"></div>
    <div class="col-lg-3 well well-sm">
        <p>${examination.symptom}</p>
    </div>
    <div class="col-lg-3 well well-sm">
        <p>${examination.examination}</p>
    </div>
    <div class="col-lg-3 well well-sm">
        <p>${examination.comment}</p>
    </div>
    <div class="col-lg-1"></div>

</div>

</#macro>