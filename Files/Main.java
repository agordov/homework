package homework.Files;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try (FileIterator fileIterator = new FileIterator(new File("src/homework/Files/test.txt"))) {
            while (fileIterator.hasNext()) {
                System.out.println(fileIterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
