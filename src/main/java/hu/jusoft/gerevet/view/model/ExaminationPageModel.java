package hu.jusoft.gerevet.view.model;

import hu.jusoft.gerevet.repository.model.FileData;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class ExaminationPageModel {
    private String id;
    private PatientPageModel patient;
    private AnimalPageModel animal;
    private InvoicePageModel invoice;
    private List<FileData> pictures;
    private List<FileData> documents;
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

    public ExaminationPageModel(String id, PatientPageModel patient, AnimalPageModel animal, InvoicePageModel invoice, List<FileData> pictures, List<FileData> documents, Date examinationDate, String symptom, String examination, String comment, BigDecimal bruttoPrice) {
        this(id, patient, animal, invoice, examinationDate, bruttoPrice);
        this.pictures = pictures;
        this.documents = documents;
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
    public List<FileData> getPictures() {
        return pictures;
    }
    public List<FileData> getDocuments() {
        return documents;
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
