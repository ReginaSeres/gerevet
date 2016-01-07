package hu.jusoft.gerevet.view.model;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class PatientPageModel {
    private String id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String emailAddress;

    public PatientPageModel() {}

    public PatientPageModel(String name, String address, String city, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public PatientPageModel(String id, String name, String address, String city, String phoneNumber, String emailAddress) {
        this(name, address, city, phoneNumber, emailAddress);
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
