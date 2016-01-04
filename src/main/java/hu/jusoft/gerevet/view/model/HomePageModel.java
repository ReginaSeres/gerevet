package hu.jusoft.gerevet.view.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Regina Seres on 12/15/2015.
 */
public class HomePageModel {
    private final String examinationId;
    private final String invoiceNumber;
    private final String patientId;
    private final String patientName;
    private final String animalId;
    private final String animalName;
    private final BigDecimal bruttoValue;
    private final Date examinationDate;

    public HomePageModel(String examinationId, String invoiceNumber, String patientId, String patientName, String animalId, String animalName, BigDecimal bruttoValue, Date examinationDate) {
        this.examinationId = examinationId;
        this.invoiceNumber = invoiceNumber;
        this.patientId = patientId;
        this.patientName = patientName;
        this.animalId = animalId;
        this.animalName = animalName;
        this.bruttoValue = bruttoValue;
        this.examinationDate = examinationDate;
    }

    public String getExaminationId() {
        return examinationId;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public String getPatientId() {
        return patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public String getAnimalId() {
        return animalId;
    }
    public String getAnimalName() {
        return animalName;
    }
    public BigDecimal getBruttoValue() {
        return bruttoValue;
    }
    public Date getExaminationDate() {
        return examinationDate;
    }
}
