package main.lesson11_Lection;

public class Main {
    public static void main(String[] args) {
        // enum
//        DayOfWeek dayOne = DayOfWeek.MON;  // ссылка на обьект класса enum
//
//        DayOfWeek dayTwo = DayOfWeek.valueOf("FRI");  // это мы вытягиваем обьект по его названию обьекта из enum класса
//
//        System.out.println(dayTwo.getFullName());
//
//        System.out.println(dayOne.getFullName());
//        System.out.println(dayOne.getOrder());
        // DayOfWeek.values(); - возвращает массив всех объектов класса

//        Car car = new Car("BMW","Black");
//        System.out.println(Car.getQuantity());

        Doctor doctor = new Doctor("Mike", "Psyholog");
        Surgery surgery = new Surgery("Greg");

        doctor.examination();

        surgery.examination();
        surgery.surgery();

        GeneralDoctor generalDoctor = new GeneralDoctor("Gregory", "LOR");

        generalDoctor.surgery();
        generalDoctor.learnSurgery();
        generalDoctor.surgery();



    }
}
