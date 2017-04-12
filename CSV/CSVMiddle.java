package homework.CSV;

import java.io.*;
import java.util.*;
import java.util.List;

public class CSVMiddle {
    private static final String SEPARATOR = ";";
    private static List<List<String>> fileText;

    private int randNum(int low, int high) {
        return (new Random().nextInt(high - low + 1) + low);
    }

    private void writeStringCSV(FileWriter writer, String str) throws IOException{
            writer.write(str);
    }

    private void createCSV(File file, int stepNum, double T) throws IllegalStateException{
        try (FileWriter writer = new FileWriter(file)){
            for (int i = 0; i < stepNum; i++) {
                writeStringCSV(writer, i * T + SEPARATOR + randNum(0, 100) + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void writeCSV(File file) throws IllegalStateException{
        try (FileWriter writer = new FileWriter(file)) {
            for (List<String> e : fileText) {
                String str = "";
                for (int i = 0 ; i < e.size(); i++) {
                    str = str + e.get(i) + (i == (e.size()-1) ? "" : SEPARATOR);
                }
                writeStringCSV(writer, str + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void addColumn(List<String> column) {
        addColumn(column, fileText.get(0).size());
    }

    private void addColumn(List<String> column, int index) {
        for (int i = 0; i < fileText.size(); i++) {
            fileText.get(i).add(index, column.get(i));
        }
    }

    private List<List<String>> readCSV(File file) throws IllegalStateException{
        List<List<String>> text = new ArrayList<List<String>>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] line;
            int lines = lineCount(file);
            for (int i = 0 ; i < lines; i++) {
                line = reader.readLine().split(SEPARATOR);
                text.add(new ArrayList<>(Arrays.asList(line)));
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return text;
    }

    private int lineCount(File file) throws IOException{
        int i = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while(reader.readLine() != null) {
            i++;
        }
        return i;
    }

    private void middleInPeriod(List<List<String>> in, int middlePeriod) {
        int[] middleCount = new int[middlePeriod];
        List<String> middles = new ArrayList<>();
        int cur;
        int sum = 0;
        for (int i = 0; i < in.size(); i++) {
            cur  = Integer.parseInt(in.get(i).get(1));
            if (i >= middlePeriod-1) {
                sum = sum - middleCount[i % middlePeriod] + cur;
                middles.add(i - middlePeriod/2, "" + (double)sum/middlePeriod);
            } else {
                sum += cur;
                middles.add("");
            }
            middleCount[i % middlePeriod] = cur;
        }
        addColumn(middles);
    }

    private void countMiddle(File file, int middlePeriod) {
        fileText = readCSV(file);
        middleInPeriod(fileText, middlePeriod);
        writeCSV(file);
    }

    public static void main(String[] args) {
        File file = new File("src/homework/CSV/out.txt");
        CSVMiddle csvMiddle = new CSVMiddle();
        double T = 0.2;
        int stepNum = 100;
        csvMiddle.createCSV(file, stepNum, T);
        int middlePeriod = 3;
        csvMiddle.countMiddle(file, middlePeriod);
    }
}
