package homework.Files;

public class Main {
    public static void main(String[] args) {
        FileIterator fileIterator = new FileIterator("");
        while (fileIterator.hasNext()) {
            System.out.println(fileIterator.next());
        }
    }
}
