<#import "spring.ftl" as spring />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/listOfExamination.ftl">

<@header />

<div class="row">
    <div class="col-md-10">
        <@fields patient
        "name,city,address,phoneNumber,emailAddress,"
        "dot-circle-o,map-marker,map-marker,phone,envelope-o"
        "Név,Város,Cím,Telefon,Email"/>
    </div>
    <div class="col-md-2">
        <a href="/editPatient/${patient.id}" class="btn btn-primary">Szerkesztés</a>
    </div>
</div>

<div class="row">
    <@listOfExamination examinations/>
</div>

<@footer />