package hu.jusoft.gerevet.view.model;

import hu.jusoft.gerevet.repository.model.Item;

import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 1/5/2016.
 */
public class NewExaminationPageModel {
    private String patientId;
    private String patientName;
    private String patientCity;
    private String patientAddress;
    private String patientPhoneNumber;
    private String patientEmailAddress;

    private String animalId;
    private String animalName;
    private String animalSpecies;
    private String animalBreed;
    private String animalSex;
    private int animalAge;

    private Date examinationDate;
    //private List<Byte> documents;
    private String examinationSymptom;
    private String examinationExamination;
    private String examinationComment;

    //private List<Byte> pictures;

    private String invoiceId;
    private Date invoiceDate;
    private Date invoicePaymentDeadline;
    private Date invoiceDayOfPayment;

    private List<Item> firstGroupDatas;

    public List<Item> getFirstGroupDatas() {
        return firstGroupDatas;
    }
    public void setFirstGroupDatas(List<Item> firstGroupDatas) {
        this.firstGroupDatas = firstGroupDatas;
    }

    public String getPatientId() {
        return patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public String getPatientCity() {
        return patientCity;
    }
    public String getPatientAddress() {
        return patientAddress;
    }
    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }
    public String getPatientEmailAddress() {
        return patientEmailAddress;
    }
    public String getAnimalId() {
        return animalId;
    }
    public String getAnimalName() {
        return animalName;
    }
    public String getAnimalSpecies() {
        return animalSpecies;
    }
    public String getAnimalBreed() {
        return animalBreed;
    }
    public String getAnimalSex() {
        return animalSex;
    }
    public int getAnimalAge() {
        return animalAge;
    }
    public Date getExaminationDate() {
        return examinationDate;
    }
    public String getExaminationSymptom() {
        return examinationSymptom;
    }
    public String getExaminationExamination() {
        return examinationExamination;
    }
    public String getExaminationComment() {
        return examinationComment;
    }
    public String getInvoiceId() {
        return invoiceId;
    }
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    public Date getInvoicePaymentDeadline() {
        return invoicePaymentDeadline;
    }
    public Date getInvoiceDayOfPayment() {
        return invoiceDayOfPayment;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }
    public void setPatientEmailAddress(String patientEmailAddress) {
        this.patientEmailAddress = patientEmailAddress;
    }
    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public void setAnimalSpecies(String animalSpecies) {
        this.animalSpecies = animalSpecies;
    }
    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }
    public void setAnimalSex(String animalSex) {
        this.animalSex = animalSex;
    }
    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }
    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }
    public void setExaminationSymptom(String examinationSymptom) {
        this.examinationSymptom = examinationSymptom;
    }
    public void setExaminationExamination(String examinationExamination) {
        this.examinationExamination = examinationExamination;
    }
    public void setExaminationComment(String examinationComment) {
        this.examinationComment = examinationComment;
    }
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public void setInvoicePaymentDeadline(Date invoicePaymentDeadline) {
        this.invoicePaymentDeadline = invoicePaymentDeadline;
    }
    public void setInvoiceDayOfPayment(Date invoiceDayOfPayment) {
        this.invoiceDayOfPayment = invoiceDayOfPayment;
    }
}
