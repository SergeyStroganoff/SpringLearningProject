package org.example.entities;

public class Person {
    private Pet pet;
    private String fullName;
    private int age;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public void callPet() {
        System.out.println(pet.getVoice());
    }
}
