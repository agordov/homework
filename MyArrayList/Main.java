package homework.MyArrayList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T> void printArray(List<T> in) {
        for (int i = 0; i < in.size() ; i++) {
            System.out.print(in.get(i) + " ");
        }
        System.out.println();
    }

    public static <T> double measure(Object arr, String methodName, Class<?>[] params, Object[] args, long iterationNumber) {
        long startTime, endTime = startTime = 0;
        startTime = System.nanoTime();
        try {
            if (!methodName.contains(arr.getClass().getSimpleName())) {
                Method method = arr.getClass().getDeclaredMethod(methodName, params);
                startTime = System.nanoTime();
                for (long i = 0 ; i < iterationNumber; i++) {
                    method.invoke(arr, args);
                }
                endTime = System.nanoTime();
            }
            else {
                Constructor constructor = arr.getClass().getConstructor(params);
                startTime = System.nanoTime();
                for (long i = 0 ; i < iterationNumber; i++) {
                    constructor.newInstance(args);
                }
                endTime = System.nanoTime();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (endTime - startTime)/1e6;
    }

    public static void main(String[] args) {
        final long N = 1_000_000;
        List<Integer> myArr = new OwnArrayList<Integer>();
        List<Integer> origin = new ArrayList<Integer>();
        System.out.println("OwnArrayList.add - " + measure(myArr, "add", new Class[]{Object.class}, new Object[]{new Integer(123)}, N) + "ms");
        System.out.println("ArrayList.add - " + measure(origin, "add", new Class[]{Object.class}, new Object[]{new Integer(123)}, N) + "ms");
        /*
        dangerous behaviour because sometimes there is no enough heap

        System.out.println("OwnArrayList.add(index) - " + measure(myArr, "add", new Class[]{int.class, Object.class}, new Object[]{13545, new Integer(123)}, N) + "ms");
        System.out.println("ArrayList.add(index) - " + measure(origin, "add", new Class[]{int.class, Object.class}, new Object[]{74895, new Integer(123)}, N) + "ms");
        */
        System.out.println("OwnArrayList.clear - " + measure(myArr, "clear", new Class[]{}, new Object[]{}, 1) + "ms");
        System.out.println("ArrayList.clear - " + measure(origin, "clear", new Class[]{}, new Object[]{}, 1) + "ms");
        System.out.println("OwnArrayList() - " + measure(myArr, "OwnArrayList", new Class[]{}, new Object[]{}, N) + "ms");
        System.out.println("ArrayList() - " + measure(origin, "ArrayList", new Class[]{}, new Object[]{}, N) + "ms");
    }
}
