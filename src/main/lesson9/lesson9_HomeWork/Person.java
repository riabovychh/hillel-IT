package main.lesson9.lesson9_HomeWork;

import java.util.Scanner;

public class Person implements Displayable {
    private String name;
    private int age;
    private String profession;


    public Person(String name, int age, PersonRole role) throws MyOwnException {

        if (age < 0) {
            System.out.println("Age cannot be negative. It will be changed to positive.");
            this.age = Math.abs(age);
        } else {
            this.age = age;
        }

        setName(name);
        this.profession = String.valueOf(role);
    }

    // setters
    public void setProfession(PersonRole role) {
        this.profession = String.valueOf(role);
    }

    public void setAge(int age) {
            this.age = age;
    }

    public void setName(String name) throws MyOwnException {
        if (name == null || name.isEmpty()) {
            throw new MyOwnException("Name cannot be null.");
        }
        this.name = name;
    }

    // getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public void displayInformation(){
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Profession: " + getProfession());
    }
}
