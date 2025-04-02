package lesson9.lesson9_HomeWork;

import java.util.Scanner;

import static lesson9.lesson9_HomeWork.Person.*;

public class Main {
    public static void main(String[] args) throws MyOwnException {
        Person person1 = new Man("John", -30, PersonRole.ENGINEER);
        Person person2 = new Woman("Mary", 25, PersonRole.TEACHER);
        Person person3 = null;

        // exception with empty name (my own)
        try {
            person3 = new Man("", 35, PersonRole.DOCTOR);
        } catch (MyOwnException e) {
            System.out.println(e.getMessage() + " Please enter the name.");
            Scanner scanner = new Scanner(System.in);
            String name;

            while (true) {
                System.out.print("Enter name: ");
                name = scanner.nextLine();

                if (name != null && !name.isEmpty()) {
                    person3 = new Man(name, 35, PersonRole.DOCTOR);
                    break;
                } else {
                    System.out.println("Name cannot be empty. Please enter a valid name.");
                }}
        }

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
