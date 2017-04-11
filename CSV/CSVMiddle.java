package homework.CSV;

import java.io.*;
import java.util.*;
import java.util.List;

public class CSVMiddle {
    private static final String separator = ";";
    private static List<ArrayList<String>> fileText;

    private static int randNum(int low, int high) {
        return (new Random().nextInt(high - low + 1) + low);
    }

    private static void writeStringCSV(FileWriter writer, String str) throws IOException{
            writer.write(str);
    }

    private static void createCSV(File file, int stepNum, double T) {
        try (FileWriter writer = new FileWriter(file)){
            for (int i = 0; i < stepNum; i++) {
                writeStringCSV(writer, i * T + separator + randNum(0, 100) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeCSV(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (ArrayList<String> e : fileText) {
                String str = "";
                for (int i = 0 ; i < e.size(); i++) {
                    str = str + e.get(i) + (i == (e.size()-1) ? "" :separator);
                }
                writeStringCSV(writer, str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addColumn(List<String> column) {
        addColumn(column, fileText.get(0).size());
    }

    private static void addColumn(List<String> column, int index) {
        for (int i = 0; i < fileText.size(); i++) {
            fileText.get(i).add(index, column.get(i));
        }
    }

    private static List<ArrayList<String>> readCSV(File file) {
        List<ArrayList<String>> text = new ArrayList<ArrayList<String>>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] line;
            int lines = lineCount(file);
            for (int i = 0 ; i < lines; i++) {
                line = reader.readLine().split(separator);
                text.add(new ArrayList<>(Arrays.asList(line)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private static int lineCount(File file) {
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while(reader.readLine() != null) {
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static void middleInPeriod(List<ArrayList<String>> in, int middlePeriod) {
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

    private static void countMiddle(File file, int middlePeriod) {
        fileText = readCSV(file);
        middleInPeriod(fileText, middlePeriod);
        writeCSV(file);
    }

    public static void main(String[] args) {
        File file = new File("src/homework/CSV/out.txt");
        double T = 0.2;
        int stepNum = 100;
        createCSV(file, stepNum, T);
        int middlePeriod = 3;
        countMiddle(file, middlePeriod);
    }
}
