<#import "spring.ftl" as spring />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/listOfExamination.ftl">

<@header />

<div class="row">
    <div class="col-md-10">
        <form class="form-horizontal" action="/updatePatient" method="post" name="patient">
            <@field "Név" "dot-circle-o">
                <input type="text" class="form-control" name="name" value="${patient.name}"/>
            </@field>

            <@field "Város" "dot-circle-o">
                <input type="text" class="form-control" name="city" value="${patient.city}"/>
            </@field>

            <@field "Cím" "dot-circle-o">
                <input type="text" class="form-control" name="address" value="${patient.address}"/>
            </@field>

            <@field "Telefon" "dot-circle-o">
                <input type="text" class="form-control" name="phoneNumber" value="${patient.phoneNumber}"/>
            </@field>

            <@field "Email" "dot-circle-o">
                <input type="text" class="form-control" name="email" value="${patient.emailAddress}"/>
            </@field>

            <div class="form-group">
                <div class="col-sm-12">
                    <button type="submit" class="btn btn-primary">
                        <i class="fa fa-save button-icon"></i>
                        <@label "button.save" />
                    </button>
                    <a class="btn btn-primary" id="backBtn" href="/patient/${patient.id}">
                        <i class="fa fa-arrow-circle-o-left button-icon"></i>
                        <@label "button.cancel" />
                    </a>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="row">
    <@listOfExamination examinations/>
</div>

<@footer />