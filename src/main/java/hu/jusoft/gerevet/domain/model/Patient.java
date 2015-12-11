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

    public Patient() {}

    public Patient(String id, String name, String address, String city, String phoneNumber, String emailAddress) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
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
}
