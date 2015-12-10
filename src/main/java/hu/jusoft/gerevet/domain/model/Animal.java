package hu.jusoft.gerevet.domain.model;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public class Animal {
    private String id;
    private String animal;
    private String species;
    private String sort;
    private String sex;
    private int age;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
