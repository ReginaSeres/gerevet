<#import "spring.ftl" as spring />
<#import "directive/control.ftl" as ui />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/examinationData.ftl">
<#include "macros/picturesData.ftl">
<#include "macros/invoiceData.ftl">
<#include "macros/animalData.ftl">
<#include "macros/addPatientForExamination.ftl">
<#include "macros/addAnimalForExamination.ftl">
<#include "macros/addExaminationForExamination.ftl">
<#include "macros/addPicturesForExamination.ftl">
<#include "macros/addInvoiceForExamination.ftl">
<#global ftlDebug = true >
<@header />

<form class="form-horizontal" action="/saveExamination" method="post" name="examinationPageModel" >
    <div class="row">
        <div class="col-lg-6">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><@label "examination.panel.header.animal"/>:</h3>
                </div>
                <div class="panel-body">
                    <@addAnimalForExamination/>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><@label "examination.panel.header.patient"/>:</h3>
                </div>
                <div class="panel-body">
                    <@addPatientForExamination/>
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
                <div class="tab-pane fade active in" id="examination"><@addExaminationForExamination/></div>
                <div class="tab-pane fade" id="pictures"><@addPicturesForExamination/></div>
                <div class="tab-pane fade" id="invoice"><@addInvoiceForExamination/></div>
            </div>
        </div>
    </div>

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

    <button type="submit" id="saveExamination" class="btn btn-primary"><@label "button.save" /></button>
</form>

<@footer />