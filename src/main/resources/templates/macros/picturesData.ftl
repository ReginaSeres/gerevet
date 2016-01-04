<#macro picturesData pictures>
    <#list pictures as picture>
        <div class="col-lg-2 col-md-4 col-xs-6 thumb">
            <a class="thumbnail" href="#">
                <img src="/getPhoto/${picture}" alt="Profile Photo" height="20px" class="img-responsive"/>
            </a>
        </div>
    </#list>
</#macro>