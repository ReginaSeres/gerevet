<#macro addPatientForExamination>
    <@field "animal.label.patient" "dot-circle-o">
        <select id="patient" name="patient" class="selectpicker" data-live-search="true">
            <#list patients as patient>
                <option value="${patient.id}">${patient.name}</option>
            </#list>
        </select>
    </@field>

    <@field "patient.label.name" "dot-circle-o">
        <input type="text" class="form-control" id="patient_name" name="name" />
    </@field>

    <@field "patient.label.city" "map-marker">
        <input type="text" class="form-control" id="patient_city" name="city" />
    </@field>

    <@field "patient.label.address" "map-marker">
        <input type="text" class="form-control" id="patient_address" name="address" />
    </@field>

    <@field "patient.label.phone" "phone">
        <input type="text" class="form-control" id="patient_phoneNumber" name="phoneNumber" />
    </@field>

    <@field "patient.label.email" "envelope-o">
        <input type="number" min="0" class="form-control" id="patient_emailAddress" name="emailAddress" />
    </@field>
</#macro>