package lesson9_HomeWork;

public class Person {
    String name;
    int age;
    String profession;

    // constructor
    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    // setters
    public void setProfession(String profession) {
        this.profession = profession;
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

}
