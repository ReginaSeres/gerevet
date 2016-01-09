package hu.jusoft.gerevet.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Regina Seres on 12/13/2015.
 */
@Document(collection = "patients")
public class Patient implements Serializable {
    private String id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String emailAddress;
    private List<Animal> animal;

    public Patient() {}

    public Patient(String name, String address, String city, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Patient(String id, String name, String address, String city, String phoneNumber, String emailAddress, List<Animal> animal) {
        this(name, address, city, phoneNumber, emailAddress);
        this.id = id;
        this.animal = animal;
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
    public List<Animal> getAnimal() {
        return animal;
    }

}
