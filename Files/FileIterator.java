package homework.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<Object>{

    private String line = null;
    private BufferedReader reader = null;

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
            if (line == null) {
                reader.close();
                reader = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (reader != null) {
                try {
                    reader.close();
                    reader = null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
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
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            if (line == null) {
                reader.close();
                reader = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (reader != null) {
                try {
                    reader.close();
                    reader = null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return line != null;
    }

    @Override
    public Object next() {
        String nextLine = line;
        if (hasNext()) {
            try {
                line = reader.readLine();
                if (!hasNext()) {
                    reader.close();
                    reader = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nextLine;
    }
}
