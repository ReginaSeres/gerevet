<#macro addAnimalForExamination>
    <@field "animal.label.patient" "dot-circle-o">
        <select id="animalId" name="animalId" class="selectpicker" data-live-search="true" disabled>
        </select>
    </@field>

    <@field "animal.label.name" "dot-circle-o">
        <input type="text" class="form-control" id="animalName" name="animalName" disabled />
    </@field>

    <@field "animal.label.species" "genderless">
        <input type="text" class="form-control" id="animalSpecies" name="animalSpecies" disabled />
    </@field>

    <@field "animal.label.breed" "genderless">
        <input type="text" class="form-control" id="animalBreed" name="animalBreed" disabled />
    </@field>

    <@field "animal.label.sex" "venus-mars">
        <input type="text" class="form-control" id="animalSex" name="animalSex" disabled />
    </@field>

    <@field "animal.label.age" "birthday-cake">
        <input type="number" min="0" class="form-control" id="animalAge" name="animalAge" disabled />
    </@field>
</#macro>