package lesson9_HomeWork;

public class Woman extends Person {

    final static String sex = "female";

    public Woman(String name, int age, String role) {
        super(name, age, PersonRole.valueOf(role));
    }


}
