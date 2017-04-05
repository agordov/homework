package homework.Files;

import java.io.*;
import java.util.Iterator;
import java.util.Objects;

public class FileIterator implements Iterator<String> {

    private String line;
    private BufferedReader reader;

    FileIterator(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("No such file or directory " + file.getPath());
        } else if (file.isFile()) {
            try {
                reader = new BufferedReader(new FileReader(path));
                line = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("File type isn't file " + file.getPath());
        }
    }

    FileIterator(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException("No such file or directory " + file.getPath());
        } else if (file.isFile()) {
            try {
                reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("File type isn't " + file.getPath());
        }
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(line);
    }

    @Override
    public String next() {
        String nextLine = line;
        if (hasNext()) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nextLine;
    }
}
