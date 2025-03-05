package lesson9_HomeWork;

import static lesson9_HomeWork.Person.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", 30, role1);
        Person person2 = new Person("Mary", 25, role2);
        Person person3 = new Person("Bob", 35, role3);

        person1.displayInformation();
        person2.displayInformation();
        person3.displayInformation();
        System.out.println();

        person2.displayInformation();
        person2.setProfession(role4);
        System.out.println("(After the updating of profession)");
        person2.displayInformation();

    }
}
