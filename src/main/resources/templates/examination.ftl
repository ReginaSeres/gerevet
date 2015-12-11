<#include "macros/header.ftl">
<#include "macros/footer.ftl">
<#include "macros/general.ftl">
<#include "macros/examinationData.ftl">
<#include "macros/picturesData.ftl">
<#include "macros/invoiceData.ftl">
<#include "macros/animalData.ftl">

<@header />

<div class="row">
    <div class="col-lg-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Állat adatai:</h3>
            </div>
            <div class="panel-body">
                <@animalData examination.animal/>
                <div class="col-lg-12 text-right">
                    <a href="" class="btn btn-primary">Szerkesztés</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Páciens adatai:</h3>
            </div>
            <div class="panel-body">
                <@fields examination.patient
                    "name,city,address,phoneNumber,emailAddress,"
                    "dot-circle-o,examinationmap-marker,map-marker,phone,envelope-o"
                    "Név,Város,Cím,Telefon,Email"/>
                <div class="col-lg-12 text-right">
                    <a href="" class="btn btn-primary">Szerkesztés</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#examination" data-toggle="tab">Vizsgálat</a></li>
            <li><a href="#pictures" data-toggle="tab">Képek</a></li>
            <li><a href="#invoice" data-toggle="tab">Számla</a></li>
        </ul>

        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in" id="examination"><@examinationData examination /></div>
            <div class="tab-pane fade" id="pictures"><@picturesData examination.pictures /></div>
            <div class="tab-pane fade" id="invoice"><@invoiceData examination.invoice /></div>
        </div>
    </div>
</div>

<@footer />