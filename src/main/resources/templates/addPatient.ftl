<#import "spring.ftl" as spring />
<#import "directive/control.ftl" as ui />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/listOfExamination.ftl">

<@header />

<div class="row">
    <form class="form-horizontal" action="/addPatient" method="post" name="patientPageModel" >
        <div class="col-md-10">
            <@field "patient.label.name" "dot-circle-o">
                <input type="text" class="form-control" id="name" name="name" />
            </@field>

            <@field "patient.label.city" "map-marker">
                <input type="text" class="form-control" id="city" name="city" />
            </@field>

            <@field "patient.label.address" "map-marker">
                <input type="text" class="form-control" id="address" name="address" />
            </@field>

            <@field "patient.label.phone" "phone">
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" />
            </@field>

            <@field "patient.label.email" "envelope-o">
                <input type="text" class="form-control" id="emailAddress" name="emailAddress" />
            </@field>
        </div>
        <div class="col-md-2">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit" id="addPatient" class="btn btn-primary"><@label "button.save" /></button>
        </div>
    </form>
</div>

<@footer />