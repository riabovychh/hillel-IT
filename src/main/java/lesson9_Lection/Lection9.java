package lesson9_Lection;

//import main.lesson10_Lection.Dog;

import java.time.Instant;
import java.util.Date;

public class Lection9 {
    public static void main(String[] args) {
       Cat cat1 = new Cat("Murzik", new Date (2022,02,24), "black", 3.5);
//       cat1.setName("Murzik");
//       cat1.setColor("white");
//       cat1.setWeight(5);
       cat1.voice();

       Cat cat2 = new Cat("Pixel", Date.from(Instant.now()), "white", 6); // типу вiн зараз народився
//       cat2.setName("Pixel");
//       cat2.setColor("black");
//       cat2.setWeight(7);
       cat2.voice();







    }
}
