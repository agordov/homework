package homework;
import java.lang.*;
/**
 * Created by aleksey on 06.03.17.
 */
public class Puzzle4 {
    public static void main(String[] args) {
        printList(6);
    }

    public static void printList(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            if (i % 2 == 0)
                reversePrint(i);
            else
                straightPrint(i);
        }
    }

    public static void reversePrint(int n) {
        int i;
        for (i = n; i > 0; i--) {
            System.out.print(i == 1 ? i : i + "-");
        }
        System.out.println();
    }

    public static void straightPrint(int n) {
        int i;
        for (i = 1 ; i <= n; i++) {
            System.out.print(i == n ? i : i + "-");
        }
        System.out.println();
    }
}
