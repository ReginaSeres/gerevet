<#macro control ftlPath model="No_model">
    <#if ftlDebug?has_content >
    <!-- Included ftl: ${ftlPath} -->
    </#if>
    <#if ftlPath?has_content >
        <#assign this = model>
    </#if>
    <#include ftlPath >
    <#if ftlDebug?has_content >
    <!-- End ftl: ${ftlPath} -->
    </#if>
</#macro>