package lesson9_HomeWork;

public class Man extends Person {

    final static String sex = "male";

    public Man(String name, int age, String role) {
        super(name, age, PersonRole.valueOf(role));
    }

}
