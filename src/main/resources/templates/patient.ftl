<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/listOfTreatment.ftl">

<@header />

<div class="row">
    <div class="col-md-10">
        <@fields patient
        "name,city,address,phoneNumber,emailAddress,"
        "dot-circle-o,map-marker,map-marker,phone,envelope-o"
        "Név,Város,Cím,Telefon,Email"/>
    </div>
</div>

<div class="row">
    <@listOfTreatment patient.treatments/>
</div>

<@footer />