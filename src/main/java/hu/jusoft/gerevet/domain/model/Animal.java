package hu.jusoft.gerevet.domain.model;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class Animal {
    private String id;
    private Patient patient;
    private String name;
    private String species;
    private String sort;
    //this should be enum since there are countable options
    private String sex;
    private int age;

    public Animal() {};

    public Animal(String id, Patient patient, String name, String species, String sort, String sex, int age) {
        this.id = id;
        this.patient = patient;
        this.name = name;
        this.species = species;
        this.sort = sort;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public Patient getPatient() {
        return patient;
    }
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public String getSort() {
        return sort;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
}
