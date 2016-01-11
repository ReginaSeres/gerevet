package hu.jusoft.gerevet.view.model;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class AnimalPageModel {
    private String id;
    private String patient;
    private String name;
    private String species;
    private String breed;
    private String sex;
    private int age;

    public AnimalPageModel() {
    }

    public AnimalPageModel(String id, String name, String species, String breed, String sex, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getPatient() {
        return patient;
    }
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public String getBreed() {
        return breed;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
