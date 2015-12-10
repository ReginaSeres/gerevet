<#function max x y>
    <#if (x<y)><#return y><#else><#return x></#if>
</#function>

<#function min x y>
    <#if (x<y)><#return x><#else><#return y></#if>
</#function>

<#function setActive actP actF>
    <#if actP = actF><#return "active"><#else><#return "notActive"></#if>
</#function>

<#function setDisactiveFirst actP >
    <#if actP = 1><#return "disabled"><#else><#return "notActive"></#if>
</#function>

<#function setDisactiveLast actP, allP >
    <#if actP = allP><#return "disabled"><#else><#return "notActive"></#if>
</#function>

<#macro pages pageCount currentPage url>
    <#if (pageCount > 1)>
    <div class="text-center">
        <#if (pageCount < 3)>
            <#assign maximum = 2>
            <#assign mininimum = 3>
        <#else>
            <#assign maximum = 1>
            <#assign mininimum = 2>
        </#if>

        <#if (currentPage < 2)>
            <#assign interval = 1..(min(mininimum,pageCount))>
        <#elseif ((pageCount-currentPage) < 1)>
            <#assign interval = (max(1,(pageCount-maximum)))..pageCount >
        <#else>
            <#assign interval = (currentPage-1)..(currentPage+1)>
        </#if>

        <ul class="pagination pagination-sm">
            <li class=${setDisactiveFirst(currentPage)}><a href="${url?replace("*", "1")}"><i class="fa fa-angle-double-left"></i></a></li>
            <li class=${setDisactiveFirst(currentPage)}><a href="${url?replace("*", (currentPage-1)?c)}"><i class="fa fa-angle-left"></i></a></li>
            <#if !(interval?seq_contains(1))>
                <li><a href="${url?replace("*", "1")}">1</a></li>
                <#if currentPage != 3>
                    <li><a href="${url?replace("*", "2")}">2</a></li>
                    <li><a>...</a><li> <#rt>
                </#if>

            </#if>

            <#list interval as page>
                <li class=${setActive(page,currentPage)}>
                    <#if page = currentPage>
                        <a>${page?c}</a>
                    <#else>
                        <a href="${url?replace("*", page?c)}">${page?c}</a> <#t>
                    </#if>
                </li>
            </#list>

            <#if !(interval?seq_contains(pageCount))>
                <#if (currentPage != pageCount-2)>
                    <#if (currentPage != pageCount-3)>
                        <li><a>...</a></li>
                    </#if>
                    <li><a href="${url?replace("*", (pageCount-1)?c)}">${(pageCount-1)?c}</a></li>
                </#if>
                <li><a href="${url?replace("*", pageCount?c)}">${pageCount?c}</a></li>
            </#if>
            <li class=${setDisactiveLast(currentPage, pageCount)}><a href="${url?replace("*", (currentPage+1)?c)}"><i class="fa fa-angle-right"></i></a></li>
            <li class=${setDisactiveLast(currentPage, pageCount)}><a href="${url?replace("*", pageCount?c)}"><i class="fa fa-angle-double-right"></i></a></li>
        </ul>
    </div>
    </#if>
</#macro>