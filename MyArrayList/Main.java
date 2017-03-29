package homework.MyArrayList;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static <T> void printArray(List<T> in) {
        for (int i = 0; i < in.size() ; i++) {
            System.out.print(in.get(i) + " ");
        }
        System.out.println();
    }

    public static <T> double measure(Object arr, String methodName, Class<?>[] params, Object[] args, int iterationNumber) {
        long startTime, endTime = startTime = 0;
        startTime = System.nanoTime();
        try {
            Method method = arr.getClass().getDeclaredMethod(methodName, params);
            startTime = System.nanoTime();
            for (int i = 0 ; i < iterationNumber; i++) {
                method.invoke(arr, args);
            }
            endTime = System.nanoTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (endTime - startTime)/1e6;
    }

    public static void main(String[] args) {
        List<Integer> myArr = new OwnArrayList<Integer>();
        List<Integer> origin = new ArrayList<Integer>();
        System.out.println("OwnArrayList.add - " + measure(myArr, "add", new Class[]{Object.class}, new Object[]{new Integer(123)}, 1_000_000) + "ms");
        System.out.println("ArrayList.add - " + measure(origin, "add", new Class[]{Object.class}, new Object[]{new Integer(123)}, 1_000_000) + "ms");
        System.out.println("OwnArrayList.clear - " + measure(myArr, "clear", new Class[]{}, new Object[]{}, 1_000_000) + "ms");
        System.out.println("ArrayList.clear - " + measure(origin, "clear", new Class[]{}, new Object[]{}, 1_000_000) + "ms");
    }
}
