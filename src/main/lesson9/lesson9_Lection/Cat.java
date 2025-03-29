package lesson9.lesson9_Lection;

import java.util.Date;

public class Cat extends Animal {
//    public String name;
//    protected String color;
//    Date birthday;
//    private double weight;
    public Cat(String name, Date birthday, String color, double weight) {
        super(name, birthday, color, weight);
//        this.name = name;
//        this.color = color;
//        this.birthday = birthday;
//        this.weight = weight;
    }

    public void voice(){
        System.out.println("Meow, my name is: " + name); // переопределили родительский метод
    }

//    public String getName() {
//        return name;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public void voice(){
//        System.out.println("Meow " + name );
//    }
//
//    public void setName (String catName) {
//        name = catName;
//    }
//
//    public void eat(Food food){
//        System.out.println("Cat + "+name+" eats food "+food.name);
//    }
//
//    public double getAge() {
//        return new Date().getYear() - birthday.getYear();
//    }

}
