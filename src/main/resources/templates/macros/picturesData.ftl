<#macro picturesData pictures>
    <#list pictures as picture>
        <div class="col-lg-2 col-md-4 col-xs-6 thumb margin-top-for-tab">
            <a class="thumbnail" href="#">
                <img src="/getFile/${picture.id}" alt="${picture.name}" height="20px" class="img-responsive"/>
            </a>
        </div>
    </#list>
</#macro>