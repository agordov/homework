package homework.Files;

import java.io.*;
import java.util.Iterator;
import java.util.Objects;

public class FileIterator implements Iterator<String> {

    private String line;
    private BufferedReader reader;

    FileIterator(String path) throws IOException {
        reader = new BufferedReader(new FileReader(path));
        line = reader.readLine();
    }

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
        if (hasNext()) {
            try {
                line = reader.readLine();
                if (Objects.isNull(line)) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        return nextLine;
    }
}
