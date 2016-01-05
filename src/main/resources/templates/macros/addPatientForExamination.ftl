<#macro addPatientForExamination>
    <@field "animal.label.patient" "dot-circle-o">
        <select id="patientId" name="patientId" class="selectpicker" data-live-search="true">
            <option value="-1"><@label "examination.select.patient.select_one_patient"/></option>
            <#list patients as patient>
                <option value="${patient.id}">${patient.name}</option>
            </#list>
        </select>
    </@field>

    <@field "patient.label.name" "dot-circle-o">
        <input type="text" class="form-control" id="patientName" name="patientName" />
    </@field>

    <@field "patient.label.city" "map-marker">
        <input type="text" class="form-control" id="patientCity" name="patientCity" />
    </@field>

    <@field "patient.label.address" "map-marker">
        <input type="text" class="form-control" id="patientAddress" name="patientAddress" />
    </@field>

    <@field "patient.label.phone" "phone">
        <input type="text" class="form-control" id="patientPhoneNumber" name="patientPhoneNumber" />
    </@field>

    <@field "patient.label.email" "envelope-o">
        <input type="text" class="form-control" id="patientEmailAddress" name="patientEmailAddress" />
    </@field>
</#macro>