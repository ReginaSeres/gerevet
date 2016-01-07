<#macro addExaminationForExamination>


<div class="col-lg-12 margin-top-for-tab">
    <div class="col-lg-2">
        <strong><@label "examination.label.date" />: </strong>
    </div>
    <div class="col-lg-3">
        <input type="text" id="datepicker" class="input-sm form-control date-picker-input datepicker" name="examinationDate" />
    </div>
</div>

<div class="margin-top-for-tab">
<div class="col-lg-3 well well-sm margin-top-for-tab">
    <textarea rows="6" cols="33" name="examinationSymptom" placeholder="<@label "examination.label.symptom" />"></textarea>
</div>
<div class="col-lg-3 well well-sm margin-top-for-tab">
    <textarea rows="6" cols="33" name="examinationExamination" placeholder="<@label "examination.label.examination" />"></textarea>
</div>
<div class="col-lg-3 well well-sm margin-top-for-tab">
    <textarea rows="6" cols="33" name="examinationComment" placeholder="<@label "examination.label.comment" />"></textarea>
</div>

<div class="col-lg-3">
    <p><strong><@label "examination.label.documents" />: </strong></p>
    <input type="file" name="documentsFiles[0]" class="filestyle" data-buttonName="btn-primary">
    <input type="file" name="documentsFiles[1]" class="filestyle" data-buttonName="btn-primary">
</div>
</div>
</#macro>