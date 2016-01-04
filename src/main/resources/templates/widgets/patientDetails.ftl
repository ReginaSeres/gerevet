<#include "/macros/general.ftl">
<span class="updatable hidden" data-name="id">${this.id}</span>
<@field "patient.label.name" "dot-circle-o">
    <span id="patientName" class="editable updatable" data-name="name">${this.name}</span>
</@field>

<@field "patient.label.city" "map-marker">
    <span id="patientCity" class="editable updatable" data-name="city">${this.city}</span>
</@field>

<@field "patient.label.address" "map-marker">
    <span id="patientAddress" class="editable updatable" data-name="address">${this.address}</span>
</@field>

<@field "patient.label.phone" "phone">
    <span id="patientPhoneNumber" class="editable updatable" data-name="phoneNumber">${this.phoneNumber}</span>
</@field>

<@field "patient.label.email" "envelope-o">
    <span id="patientEmailAddress" class="editable updatable" data-name="emailAddress">${this.emailAddress}</span>
</@field>