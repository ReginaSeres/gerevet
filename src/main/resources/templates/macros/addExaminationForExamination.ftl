<#macro addExaminationForExamination>

<div class="col-lg-12">
    <div class="col-lg-12 examinationDateMargin">
        <div class="col-lg-2">
            <strong><@label "examination.label.date" />: </strong>
        </div>
        <div class="col-lg-3">
            <input type="text" id="datepicker" class="input-sm form-control date-picker-input datepicker" name="examinationDate" />
        </div>
    </div>
    TODO: Documentations
</div>
<div class="col-lg-12">
    <div class="col-lg-1"></div>
    <div class="col-lg-3 well well-sm">
        <textarea rows="6" cols="33" name="examinationSymptom" placeholder="<@label "examination.label.symptom" />"></textarea>
    </div>
    <div class="col-lg-3 well well-sm">
        <textarea rows="6" cols="33" name="examinationExamination" placeholder="<@label "examination.label.examination" />"></textarea>
    </div>
    <div class="col-lg-3 well well-sm">
        <textarea rows="6" cols="33" name="examinationComment" placeholder="<@label "examination.label.comment" />"></textarea>
    </div>
    <div class="col-lg-1"></div>
</div>
</#macro>