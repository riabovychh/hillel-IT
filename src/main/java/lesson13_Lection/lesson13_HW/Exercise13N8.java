package lesson13_Lection.lesson13_HW;

import java.util.Arrays;
import java.util.TreeSet;

public class Exercise13N8 {
    // Умова: Об'єднайте два TreeSet у третій TreeSet, зберігаючи унікальність елементів.
    //Приклад: Для TreeSet A = [1, 2, 3] та TreeSet B = [3, 4, 5], очікуваний результат [1, 2, 3, 4, 5].
    public static void main(String[] args) {
        TreeSet<Integer> treeA = new TreeSet<>(Arrays.asList(1, 2, 3));
        TreeSet<Integer> treeB = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(combine(treeA, treeB));
    }

    public static TreeSet<Integer> combine (TreeSet<Integer> tree1, TreeSet<Integer> tree2) {
        TreeSet<Integer> combineTree = new TreeSet<>();
        combineTree.addAll(tree1);
        combineTree.addAll(tree2);
        return combineTree;
    }
}
