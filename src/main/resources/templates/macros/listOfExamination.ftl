<#macro listOfExamination examination>

<table class="table table-striped table-hover " style="margin-bottom: 0px;">
    <tbody>
        <#list examinations as examination>
        <tr>
            <td><a href="/examination/${examination.id}">${examination.id}</a></td>
            <td><p><a href="/animal/${examination.animal.id}">${examination.animal.name}</a></p></td>
            <td><p>${examination.bruttoPrice}</p></td>
            <td><p>${examination.examinationDate?date}</p></td>
        </tr>
        </#list>
    </tbody>
</table>

</#macro>
