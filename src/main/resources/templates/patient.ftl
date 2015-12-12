<#import "spring.ftl" as spring />
<#import "directive/control.ftl" as ui />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/listOfExamination.ftl">

<@header />

<div class="row">
    <div class="col-md-10">
        <@ui.control "/widgets/patientDetails.ftl", patient />
    </div>
    <div class="col-md-2">
        <a id="editPatient" class="btn btn-primary"><@label "button.edit" /></a>
        <a id="updatePatient" class="btn btn-primary hidden"><@label "button.save" /></a>
    </div>
</div>

<div class="row">
    <@listOfExamination examinations/>
</div>

<@footer />