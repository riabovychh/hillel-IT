package lesson9_HomeWork;

import static lesson9_HomeWork.Person.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Man("John", -30, PersonRole.ENGINEER);
        Person person2 = new Woman("Mary", 25, PersonRole.TEACHER);
        Person person3 = new Man("", 35, PersonRole.DOCTOR);

        person1.displayInformation();
        person2.displayInformation();
        person3.displayInformation();
        System.out.println();

        person2.displayInformation();
        person2.setProfession(PersonRole.EDUCATOR);
        System.out.println("(After the updating of profession)");
        person2.displayInformation();

    }
}
