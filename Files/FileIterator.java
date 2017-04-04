package homework.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class FileIterator implements Iterator<String>{

    private String line;
    private BufferedReader reader;

    FileIterator(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("No such file or directory ");
        }
        if (file.isDirectory()) {
            throw new IllegalArgumentException("File " + file.getName() + " is directory ");
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("Unable to read file " + file.getName());
        }
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    FileIterator(File file) {
        if (file.exists()) {
            throw new IllegalArgumentException("No such file or directory ");
        }
        if (file.isDirectory()) {
            throw new IllegalArgumentException("File " + file.getName() + " is directory ");
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("Unable to read file " + file.getName());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            this.reader = reader;
            line = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
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
