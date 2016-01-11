<#import "spring.ftl" as spring />
<#import "directive/control.ftl" as ui />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/listOfExamination.ftl">

<@header />

<div class="row">
    <form class="form-horizontal" action="/addAnimal" method="post" name="animalPageModel" >
        <div class="col-md-10">
            <@field "animal.label.patient" "dot-circle-o">
                <select id="patient" name="patient" class="selectpicker" data-live-search="true">
                    <#list patients as patient>
                        <option <#if patientId = patient.id>selected</#if> value="${patient.id}">${patient.name}</option>
                    </#list>
                </select>
            </@field>

            <@field "animal.label.name" "dot-circle-o">
                <input type="text" class="form-control" id="name" name="name" />
            </@field>

            <@field "animal.label.species" "genderless">
                <input type="text" class="form-control" id="species" name="species" />
            </@field>

            <@field "animal.label.breed" "genderless">
                <input type="text" class="form-control" id="breed" name="breed" />
            </@field>

            <@field "animal.label.sex" "venus-mars">
                <input type="text" class="form-control" id="sex" name="sex" />
            </@field>

            <@field "animal.label.age" "birthday-cake">
                <input type="number" min="0" class="form-control" id="age" name="age" value="0" />
            </@field>
        </div>
        <div class="col-md-2">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit" id="addAnimal" class="btn btn-primary"><@label "button.save" /></button>
        </div>
    </form>
</div>

<@footer />