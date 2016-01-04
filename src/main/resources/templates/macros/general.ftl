<#macro label id>
    <@spring.messageText id id />
</#macro>

<#macro icon name>
    <i class="fa fa-${name}"></i>
</#macro>

<#macro field name iconName wrapperClass="col-lg-12" labelClass="col-lg-3" valueClass="col-lg-9">
    <#assign clazz>${name?replace(".", "-")}</#assign>
    <div class="field field-margin ${clazz} ${wrapperClass}">
        <div class="field-label ${labelClass}">
            <@icon iconName!"" />&nbsp;
            <@label "${name}" />
        </div>
        <div class="field-value ${valueClass}"><#nested/></div>
    </div>
</#macro>

<#macro fields map keys icons name wrapperClass="col-lg-12" labelClass="col-lg-3" valueClass="col-lg-9">
    <#assign i = 0 />
    <#list keys?split(",") as key>
        <#assign value>${map[key]!""}</#assign>
        <#if value?trim != "">
            <@field name?split(",")[i]!"" icons?split(",")[i]!"">
            ${map[key]?trim?replace("\r?\n", "<br/>", "r")}
            </@field>
        </#if>
        <#assign i = i + 1 />
    </#list>
</#macro>