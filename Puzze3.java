package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksey on 06.03.17.
 */
public class Puzze3 {
    public static final int n = 10;
    public static void main(String[] args) {
        int i;
        List<Integer> list1 = new ArrayList<Integer>();
        for (i = 0; i < n; i++)
            list1.add(i);
        printList(list1);
        List<Integer> list2 = new ArrayList<Integer>();
        for (i = 0; i < n/2; i++) {
            list2.add(2*i, list1.get(i));
            list2.add(2*i+1, list1.get(n-i-1));
        }
        System.out.println();
        printList(list2);
    }

    public static void printList(List<Integer> list1) {
        for (Integer e : list1) {
            System.out.print(e + " ");
        }
    }
}

