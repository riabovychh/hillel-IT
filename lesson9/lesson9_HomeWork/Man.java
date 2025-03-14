package lesson9_HomeWork;

public class Man extends Person {

    final static String sex = "male";

    public Man(String name, int age, PersonRole role) {
        super(name, age, PersonRole.valueOf(String.valueOf(role)));
    }

    @Override
    public void displayInformation() {
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Profession: " + getProfession() + ", Sex: " + sex);
    }
}
