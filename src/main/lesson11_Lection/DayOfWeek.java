package main.lesson11_Lection;

public enum DayOfWeek {
    MON("Monday", (byte)1),
    TEU("Tuesday", (byte)2),
    WED("Wednesday", (byte)3),
    THU("Thursday", (byte)4),
    FRI("Friday", (byte)5),
    SAT("Saturday", (byte)6),
    SUN("Sunday", (byte)7);

    private String fullName;
    private byte order;


    private DayOfWeek(String name, byte order) {   // у enum конструктор всегда private
       this.fullName = name;
       this.order = order;
    }

    public String getFullName() {
        return fullName;
    }

    public byte getOrder() {
        return order;
    }
}
