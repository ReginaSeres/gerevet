package hu.jusoft.gerevet.repository.model;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public class Animal {
    private String animalId;
    private String name;
    private String species;
    private String breed;
    private String sex;
    private int age;

    public Animal() {

    }

    public Animal(String animalId, String name, String species, String breed, String sex, int age) {
        this.animalId = animalId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
    }


    public String getAnimalId() {
        return animalId;
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

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
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
