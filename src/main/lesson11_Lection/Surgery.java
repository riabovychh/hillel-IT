package main.lesson11_Lection;

public class Surgery extends Doctor {
    public Surgery(String name) {
        super(name, "Surgery");
    }

    public void surgery() {
        System.out.println("Processing surgery");
    }

}
