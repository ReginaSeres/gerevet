<#import "spring.ftl" as spring />
<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/paging.ftl">
<#include "macros/general.ftl">
<#include "macros/examinationDashBoard.ftl">

<@header />
    <div class="row" style="padding-bottom:2em">
        <form class="navbar-form navbar-left" id="formSubmit" action="/searchName" method="post">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-search"></i></span>
                <input type="text" class="form-control" id="queryValueHeader" name="queryName"
                <#if queryName??>
                    <#if queryName != "">
                       value="${queryName}"
                    </#if>
                </#if>
                       placeholder="<@label "index.placeholder.search" />">
                <input type="hidden" name="nodeId" id="nodeId"/>
            </div>
        </form>

        <form class="navbar-form navbar-left" role="add">
            <a href="/addPatient" class="btn btn-default">+ <@label "patient" /></a>
            <a href="/addAnimal" class="btn btn-default">+ <@label "animal" /></a>
        </form>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <#list listOfExaminations as examination>
                 <@examinationDashBoard examination/>
            </#list>
        </div>
    </div>

    <div class="row">
        <@pages pageCount=pageCount currentPage=actPage url=url/>
    </div>
<@footer />