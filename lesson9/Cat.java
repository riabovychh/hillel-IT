import java.util.Date;

public class Cat {
    String name;
    String color;
    Date birthday;
    double weight;
    public Cat(String name, String color, Date birthday, double weight) {
        this.name = name;
        this.color = color;
        this.birthday = birthday;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void voice(){
        System.out.println("Meow " + name );
    }

    public void setName (String catName) {
        name = catName;
    }

    public void eat(Food food){
        System.out.println("Cat + "+name+" eats food "+food.name);
    }

    public double getAge() {
        return new Date().getYear() - birthday.getYear();
    }

}
