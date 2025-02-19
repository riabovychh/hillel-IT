public class Recursion {
//    static int sum(int n1, int n2) {
//        return n1 + n2;
//    }
    static int sum(int firstNumber, int secondNumber, int ... otherNumbers) {
        int result = firstNumber + secondNumber;
        if (otherNumbers.length > 0) {
            for (int number : otherNumbers) {
                result = sum(result, number);
            }
        }
        return result;
}
public static void main(String[] args) {
    System.out.println(sum(1, 2));}
}