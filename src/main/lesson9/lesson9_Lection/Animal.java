package lesson9.lesson9_Lection;

import java.util.Date;

public class Animal {
    protected String name;
    protected String color;
    protected Date birthday;
    protected double weight;

    public Animal(String name, Date birthday, String color, double weight) {
        this.name = name;
        this.birthday = birthday;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void voice(){
        System.out.println("Hello from Animal, my name is: " + name );
    }

    public void eat(Food food){
        System.out.println("Animal + "+name+" eats food "+food.name);
    }
}
