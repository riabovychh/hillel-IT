package main.lesson5;

public class Lesson5HW4 {
    public static String getStudentMark(int mark) {
        switch (mark) {
            case 5:
                return "Відмінно";
            case 4:
                return "Добре";
            case 3:
                return "Задовільно";
            case 2:
                return "Незадовiльно";
            case 1:
                return "Погано";
            default:
                return "Неправильна оцінка";
        }
    }

    public static void main(String[] args) {
        int mark = Integer.parseInt(args[0]);
        String result = getStudentMark(mark);

        System.out.println(result);
    }
}
