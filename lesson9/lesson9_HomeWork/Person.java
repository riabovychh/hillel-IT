package lesson9_HomeWork;

public class Person implements Displayable {
    private String name;
    private int age;
    private String profession;

    static PersonRole role1 = PersonRole.ENGINEER;
    static PersonRole role2 = PersonRole.TEACHER;
    static PersonRole role3 = PersonRole.DOCTOR;
    static PersonRole role4 = PersonRole.EDUCATOR;


    // constructor
    public Person(String name, int age, PersonRole role) {
        this.name = name;
        this.age = age;
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
    public void displayInformation() {
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Profession: " + getProfession());
    }
}
