<#include "/macros/general.ftl">
<span class="updatable hidden" data-name="id">${this.id}</span>
<@field "Név" "dot-circle-o">
    <span id="patientName" class="editable updatable" data-name="name">${this.name}</span>
</@field>

<@field "Város" "map-marker">
    <span id="patientCity" class="editable updatable" data-name="city">${this.city}</span>
</@field>

<@field "Cím" "map-marker">
    <span id="patientAddress" class="editable updatable" data-name="address">${this.address}</span>
</@field>

<@field "Telefon" "phone">
    <span id="patientPhoneNumber" class="editable updatable" data-name="phoneNumber">${this.phoneNumber}</span>
</@field>

<@field "Email" "envelope-o">
    <span id="patientEmailAddress" class="editable updatable" data-name="emailAddress">${this.emailAddress}</span>
</@field>