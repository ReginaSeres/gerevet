package hu.jusoft.gerevet.domain.model;

import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class Patient {
    private String id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String emailAddress;
    private List<Treatment> treatments;

    public Patient() {

    }

    public Patient(String id, String name, String address, String city, String phoneNumber, String emailAddress, List<Treatment> treatments) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.treatments = treatments;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public List<Treatment> getTreatments() {
        return treatments;
    }
    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
