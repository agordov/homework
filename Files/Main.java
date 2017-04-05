package homework.Files;

public class Main {
    public static void main(String[] args) {
        try {
            FileIterator fileIterator = new FileIterator("");
            while (fileIterator.hasNext()) {
                System.out.println(fileIterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
