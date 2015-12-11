package hu.jusoft.gerevet.domain.model;

import java.util.Date;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class Examination {
    private String id;
    private Patient patient;
    private Animal animal;
    private Invoice invoice;
    private Pictures pictures;
    private Date examinationDate;
    private String symptom;
    private String examination;
    private String comment;
    private int bruttoPrice;

    public Examination() {}

    public Examination(String id, Patient patient, Animal animal, Invoice invoice, Pictures pictures, Date examinationDate, String symptom, String examination, String comment, int bruttoPrice) {
        this.id = id;
        this.patient = patient;
        this.animal = animal;
        this.invoice = invoice;
        this.pictures = pictures;
        this.examinationDate = examinationDate;
        this.symptom = symptom;
        this.examination = examination;
        this.comment = comment;
        this.bruttoPrice = bruttoPrice;
    }

    public String getId() {
        return id;
    }
    public Patient getPatient() {
        return patient;
    }
    public Animal getAnimal() { return animal; }
    public Invoice getInvoice() {
        return invoice;
    }
    public Pictures getPictures() {
        return pictures;
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
    public int getBruttoPrice() {
        return bruttoPrice;
    }
}
