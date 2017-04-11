package homework.Files;

import java.io.*;
import java.util.*;

public class FileIterator implements Iterator<String>, AutoCloseable {

    private String line;
    private BufferedReader reader;

    FileIterator(File file) throws IOException {
        reader = new BufferedReader(new FileReader(file));
        line = reader.readLine();
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(line);
    }

    @Override
    public String next() throws NoSuchElementException{
        try {
            String nextLine = line;
            line = reader.readLine();
            return nextLine;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}