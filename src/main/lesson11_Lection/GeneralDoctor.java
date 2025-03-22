package main.lesson11_Lection;

public class GeneralDoctor {
    private String name;
    private String specialization;
    private Surgery  surgeryPossibility;  // создаем обьект класса Surgery

    public GeneralDoctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void surgery() {
        if (surgeryPossibility == null) {
            System.out.println("I can't surgery");
            return;
        }
        surgeryPossibility.surgery();
    }

    public void learnSurgery() {
        surgeryPossibility = new Surgery();
    }

    private class Surgery {
        public void surgery() {
            System.out.println("Processing surgery");
        }
    }
}
