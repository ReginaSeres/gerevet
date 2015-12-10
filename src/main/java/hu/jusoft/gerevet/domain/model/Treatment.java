package hu.jusoft.gerevet.domain.model;

import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class Treatment {
    private String id;
    private String patientId;
    private Date treatmentDate;
    private String symptom;
    private String treatment;
    private String comment;

    public Treatment() {

    }

    public Treatment(String id, String patientId, Date treatmentDate, String symptom, String treatment, String comment) {
        this.id = id;
        this.patientId = patientId;
        this.treatmentDate = treatmentDate;
        this.symptom = symptom;
        this.treatment = treatment;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public Date getTreatmentDate() {
        return treatmentDate;
    }
    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }
    public String getSymptom() {
        return symptom;
    }
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
