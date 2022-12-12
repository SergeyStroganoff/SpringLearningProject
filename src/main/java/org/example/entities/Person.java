package org.example.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myPerson")
// если не указывать ID, то ID будет по дефолту имя класса с маленькой буквы.
@Scope("singleton") // by default
//@Scope("prototype") // - destroy method not invoice!
public class Person {

    //@Autowired
    //@Qualifier("myCat")
    // we can use injection here - reflection used!
    private Pet pet;
    @Value("${person.fullName}")
    private String fullName;
    @Value("${person.age}")
    private int age;

    @Autowired
    // если в классе один конструктор, то можно не писать аннотацию  --- но лучше писать
    public Person(@Qualifier("myCat") Pet pet) {
        this.pet = pet;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@Autowired  we can use it here
    // We use any method ti inject
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

    @PostConstruct
    private void init() {
        System.out.println("After creation, we can initialize some resources");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("After creation, we can free our resources");
    }
}
