package homework.MyArrayList;
import java.util.*;
import java.util.function.UnaryOperator;

public class OwnArrayList <T> implements List<T>{
    private int size;
    private static final Object[] nullArray = {};
    private Object[] array;

    public OwnArrayList() {
        this.array = nullArray;
    }

    public OwnArrayList(int inCapacity) {
        if (inCapacity > 0) {
            this.size = inCapacity;
            this.array = new Object[inCapacity];
        }
        if (inCapacity == 0) {
            array = nullArray;
        }
        if (inCapacity < 0) {
            throw new IllegalArgumentException("Negative array size");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void increaseSize() {
        int newCapacity = (array.length << 1) + 1;
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public boolean add(T e) {
        if (size == array.length) {
            increaseSize();
        }
        array[size++] = e;
        return true;
    }

    public boolean inRange(int index) {
        return (index >= 0 && index < size);
    }

    @Override
    public void add(int index, T e) {
        if (!inRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            increaseSize();
        }
        Object[] oldArray = array;
        Object[] newArray = new Object[size+1];
        for (int i = 0; i <  index; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[index] = e;
        for (int i = index; i < size ; i++) {
            newArray[i+1] = oldArray[i];
        }
        array = newArray;
    }

    @Override
    public T get(int index) {
        if (!inRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (T)array[index];
    }

    @Override
    public T remove(int index) {
        if (!inRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        Object[] oldArray = array;
        Object[] newArray = new Object[size-1];
        for (int i = 0; i < index ; i++) {
            newArray[i] = oldArray[i];
        }
        for (int i = 0; i < size - index - 1; i++) {
            newArray[index+i] = oldArray[i+index+1];
        }
        array = newArray;
        size--;
        return (T)oldArray[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {

    }

    @Override
    public void sort(Comparator c) {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
