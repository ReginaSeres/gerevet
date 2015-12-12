<#import "spring.ftl" as spring />
<#import "directive/control.ftl" as ui />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/animalData.ftl">

<@header />

<div class="row">
    <div class="col-md-10">
        <@ui.control "/widgets/animalDetails.ftl", animal />
    </div>
    <div class="col-md-2">
        <a id="editAnimal" class="btn btn-primary"><@label "button.edit" /></a>
        <a id="updateAnimal" class="btn btn-primary hidden"><@label "button.save" /></a>
    </div>
</div>

<@footer />