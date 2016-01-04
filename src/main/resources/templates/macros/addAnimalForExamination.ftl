<#macro addAnimalForExamination>
    <@field "animal.label.patient" "dot-circle-o">
        <select id="patient" name="patient" class="selectpicker" data-live-search="true">
            <#list patients as patient>
                <option value="${patient.id}">${patient.name}</option>
            </#list>
        </select>
    </@field>

    <@field "animal.label.name" "dot-circle-o">
        <input type="text" class="form-control" id="animal_name" name="name" />
    </@field>

    <@field "animal.label.species" "genderless">
        <input type="text" class="form-control" id="animal_species" name="species" />
    </@field>

    <@field "animal.label.breed" "genderless">
        <input type="text" class="form-control" id="animal_breed" name="breed" />
    </@field>

    <@field "animal.label.sex" "venus-mars">
        <input type="text" class="form-control" id="animal_sex" name="sex" />
    </@field>

    <@field "animal.label.age" "birthday-cake">
        <input type="number" min="0" class="form-control" id="animal_age" name="age" />
    </@field>
</#macro>