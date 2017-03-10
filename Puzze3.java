package homework;

import java.util.ArrayList;
import java.util.List;

public class Puzze3 {
    private static final int n = 9;

    public static <T> void printList(List<T> inputArr) {
        for (T elem : inputArr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static <T> List<T> transformList(List<T> listIn) {
        List<T> listOut = new ArrayList<>();
        for (int i = 0, j = 2; i < listIn.size()-1; i++) {
            if (i % 2 == 0) {
                listOut.add(listIn.get(i/2));
            }
            else {
                listOut.add(listIn.get(listIn.size()- j++));
            }
        }
        listOut.add(listIn.get(listIn.size()-1));
        return listOut;
    }

    public static void main(String[] args) {
        List<Integer> listIn = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listIn.add(i);
        }
        printList(listIn);
        printList(transformList(listIn));
    }
}

