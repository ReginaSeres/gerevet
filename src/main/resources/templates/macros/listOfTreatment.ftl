<#macro listOfTreatment treatments>

<table class="table table-striped table-hover " style="margin-bottom: 0px;">
    <tbody>
        <#list treatments as treatment>
        <tr>
            <td><p>${treatment.symptom}</p></td>
            <td><p>${treatment.treatment}</p></td>
            <td><p>${treatment.comment}</p></td>
        </tr>
        </#list>
    </tbody>
</table>

</#macro>
