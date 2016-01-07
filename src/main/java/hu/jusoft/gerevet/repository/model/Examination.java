package hu.jusoft.gerevet.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 12/13/2015.
 */
@Document(collection = "examinations")
public class Examination {
    private String id;
    private String patientId;
    private String animalId;
    private Date examinationDate;
    private String symptom;
    private String examination;
    private String comment;
    private BigDecimal bruttoPrice;
    private List<FileData> pictures;
    private List<FileData> documents;
    private Invoice invoice;
    private Patient patient;

    public  Examination() {

    }

    public Examination(String patientId, String animalId, Date examinationDate, String symptom, String examination, String comment, BigDecimal bruttoPrice, List<FileData> documents, List<FileData> pictures, Invoice invoice, Patient patient) {
        this.patientId = patientId;
        this.animalId = animalId;
        this.examinationDate = examinationDate;
        this.symptom = symptom;
        this.examination = examination;
        this.comment = comment;
        this.bruttoPrice = bruttoPrice;
        this.documents = documents;
        this.pictures = pictures;
        this.invoice = invoice;
        this.patient = patient;
    }

    public String getId() {
        return id;
    }
    public String getPatientId() {
        return patientId;
    }
    public String getAnimalId() {
        return animalId;
    }
    public Date getExaminationDate() {
        return examinationDate;
    }
    public String getSymptom() {
        return symptom;
    }
    public String getExamination() {
        return examination;
    }
    public String getComment() {
        return comment;
    }
    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }
    public List<FileData> getPictures() {
        return pictures;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public List<FileData> getDocuments() {
        return documents;
    }
    public Patient getPatient() {
        return patient;
    }

    public void setPictures(List<FileData> pictures) {
        this.pictures = pictures;
    }

    public void setDocuments(List<FileData> documents) {
        this.documents = documents;
    }
}
