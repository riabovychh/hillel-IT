package lesson10_Lection;

import lesson9.lesson9_Lection.Animal;

import java.util.Date;

public class Dog extends Animal {  // Dog - подкласс Animal-а, он его типа расширяет
    private String breed;

    public String getDogName() {
        return this.name;
    }

    public Dog (String name, Date birthday, String color, double weight) {
        super(name, birthday, color, weight);
    }

//    public Dog (String name)  {  // мы создали конструктор класса Dog, который принимает только name, а остальные поля - по умолчанию
//        super(name, new Date(2022,02,24), "Pink", 4.5);
//    }

    public Dog (String breed)  {  // мы создали конструктор класса Dog, который принимает только bread, а остальные поля - по умолчанию
        super("Barsik", new Date(2022,02,24), "Pink", 4.5); // но тут захардкоженные данные
        this.breed = breed;
    }

    public void voice(){
        System.out.println("Woof, my name is: " + name); // переопределили родительский метод
    }



}
