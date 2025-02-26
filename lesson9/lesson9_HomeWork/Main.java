package lesson9_HomeWork;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", 30, "Engineer");
        Person person2 = new Person("Mary", 25, "Teacher");
        Person person3 = new Person("Bob", 35, "Doctor");

        System.out.println("1. Name: " + person1.getName() + ", Age: " + person1.getAge() + ", Profession: " + person1.getProfession());
        System.out.println("   Name: " + person2.getName() + ", Age: " + person2.getAge() + ", Profession: " + person2.getProfession());
        System.out.println("   Name: " + person3.getName() + ", Age: " + person3.getAge() + ", Profession: " + person3.getProfession());
        System.out.println();

        System.out.println("2. Name: " + person2.getName() + ", Age: " + person2.getAge() + ", Profession: " + person2.getProfession());
        person2.setProfession("Educator");
        System.out.println("   (After the updating of profession)");
        System.out.println("   Name: " + person2.getName() + ", Age: " + person2.getAge() + ", Profession: " + person2.getProfession());

    }
}
