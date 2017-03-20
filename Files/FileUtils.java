package homework.Files;

import java.io.File;

public class FileUtils{

    public static boolean delete(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("File " + path + " doesn't exist ");
        }
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            if (fileList == null) {
                throw new IllegalArgumentException("Directory " + path + " is empty ");
            } else {
                for (File e : fileList) {
                    delete(e.getAbsolutePath());
                }
            }
        }
        return file.delete();
    }

    public static void main(String... args) {
        String filename = "src/Files/test";
        delete(filename);
    }
}
