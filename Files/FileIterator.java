package homework.Files;

import java.io.*;
import java.util.*;

public class FileIterator implements Iterator<String> {

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
    public String next() {
        String nextLine = line;
        Exception ex;
        if (hasNext()) {
            try {
                line = reader.readLine();
                if (Objects.isNull(line)) {
                    reader.close();
                }
            } catch (IOException e) {
                ex = e;
                try {
                    if (Objects.nonNull(reader)) {
                        reader.close();
                    }
                } catch (IOException e2) {
                    throw new IllegalStateException(ex);
                }
                throw new IllegalStateException(ex);
            }
        }
        return nextLine;
    }
}