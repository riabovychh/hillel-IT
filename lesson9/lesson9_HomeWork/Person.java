package lesson9_HomeWork;

import java.util.Scanner;

public class Person implements Displayable {
    private String name;
    private int age;
    private String profession;


    public Person(String name, int age, PersonRole role) {
        // exception with age
        try {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }
            this.age = age;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " It will be changed to positive.");
            this.age = Math.abs(age);
        }
        // exception with empty name (my own)
        try {
            if (name == null || name.isEmpty()) {
                throw new MyOwnException("Name cannot be null.");
            }
            this.name = name;
        } catch (MyOwnException e) {
            System.out.println(e.getMessage() + " Please enter the name.");
            while (true) {
                System.out.print("Enter name: ");
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
                if (name != null && !name.isEmpty()) {
                    this.name = name;
                    break;
                } else {
                    System.out.println("Name cannot be empty. Please enter a valid name.");
                } }
        }
        this.profession = String.valueOf(role);
    }

    // setters
    public void setProfession(PersonRole role) {
        this.profession = String.valueOf(role);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
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
