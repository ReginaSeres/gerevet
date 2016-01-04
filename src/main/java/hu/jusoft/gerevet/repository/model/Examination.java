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
    private List<String> pictures;
    private Invoice invoice;
    private Patient patient;

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
    public List<String> getPictures() {
        return pictures;
    }
    public Invoice getInvoice() {
        return invoice;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
