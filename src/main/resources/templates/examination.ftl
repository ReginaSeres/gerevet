<#import "spring.ftl" as spring />
<#import "directive/control.ftl" as ui />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/examinationData.ftl">
<#include "macros/picturesData.ftl">
<#include "macros/invoiceData.ftl">
<#include "macros/animalData.ftl">
<#global ftlDebug = true >
<@header />

<div class="row">
    <div class="col-lg-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title"><@label "examination.panel.header.animal"/>:</h3>
            </div>
            <div class="panel-body">
                <@ui.control "/widgets/animalDetails.ftl", examination.animal />
                <div class="col-lg-12 text-right">
                    <a id="editAnimal" class="btn btn-primary"><@label "button.edit" /></a>
                    <a id="updateAnimal" class="btn btn-primary hidden"><@label "button.save" /></a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title"><@label "examination.panel.header.patient"/>:</h3>
            </div>
            <div class="panel-body">
                <@ui.control "/widgets/patientDetails.ftl", examination.patient />
                <div class="col-lg-12 text-right">
                    <a id="editPatient" class="btn btn-primary hidden "><@label "button.edit" /></a>
                    <a id="updatePatient" class="btn btn-primary disabled"><@label "button.save" /></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#examination" data-toggle="tab"><@label "examination.tab.label.examination" /></a></li>
            <li><a href="#pictures" data-toggle="tab"><@label "examination.tab.label.pictures" /></a></li>
            <li><a href="#invoice" data-toggle="tab"><@label "examination.tab.label.invoice" /></a></li>
        </ul>

        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in" id="examination"><@examinationData examination /></div>
            <div class="tab-pane fade" id="pictures"><@picturesData examination.pictures /></div>
            <div class="tab-pane fade" id="invoice"><@invoiceData examination.invoice /></div>
        </div>
    </div>
</div>

<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>

<@footer />