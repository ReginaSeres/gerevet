package hu.jusoft.gerevet.view.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class ExaminationPageModel {
    private String id;
    private PatientPageModel patient;
    private AnimalPageModel animal;
    private InvoicePageModel invoice;
    private PicturesPageModel pictures;
    private Date examinationDate;
    private String symptom;
    private String examination;
    private String comment;
    private BigDecimal bruttoPrice;

    public ExaminationPageModel() {}

    public ExaminationPageModel(String id, PatientPageModel patient, AnimalPageModel animal, InvoicePageModel invoice, Date examinationDate, BigDecimal bruttoPrice) {
        this.id = id;
        this.patient = patient;
        this.animal = animal;
        this.invoice = invoice;
        this.examinationDate = examinationDate;
        this.bruttoPrice = bruttoPrice;
    }

    public ExaminationPageModel(String id, PatientPageModel patient, AnimalPageModel animal, InvoicePageModel invoice, PicturesPageModel pictures, Date examinationDate, String symptom, String examination, String comment, BigDecimal bruttoPrice) {
        this(id, patient, animal, invoice, examinationDate, bruttoPrice);
        this.pictures = pictures;
        this.symptom = symptom;
        this.examination = examination;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }
    public PatientPageModel getPatient() {
        return patient;
    }
    public AnimalPageModel getAnimal() { return animal; }
    public InvoicePageModel getInvoice() {
        return invoice;
    }
    public PicturesPageModel getPictures() {
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
    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }
}
