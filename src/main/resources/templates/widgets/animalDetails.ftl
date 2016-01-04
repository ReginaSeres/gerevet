<#include "/macros/general.ftl">
<div class="edit-content">
<input type="hidden" name="id" class="updatable" value="${this.id}"/>
<@field "animal.label.name" "dot-circle-o">
    <span id="animalName" class="edit" data-update="name">${this.name}</span>
    <input type="text" name="name" class="hidden" value="${this.name}"/>
</@field>

<@field "animal.label.species" "genderless">
    <span id="animalSpecies" class="edit" data-update="species">${this.species}</span>
    <input type="text" name="species" class="hidden" value="${this.species}"/>
</@field>

<@field "animal.label.breed" "genderless">
    <span id="animalBreed" class="edit" data-update="breed">${this.breed}</span>
    <input type="text" name="breed" class="hidden" value="${this.breed}"/>
</@field>

<@field "animal.label.sex" "venus-mars">
    <span id="animalSex" class="edit" data-update="sex">${this.sex}</span>
    <input type="text" name="sex" class="hidden" value="${this.sex}"/>
</@field>

<@field "Kor" "birthday-cake">
    <span id="animalAge" class="edit" data-update="age">${this.age}</span>
    <input type="text" name="age" class="hidden" value="${this.age}"/>
</@field>
</div>