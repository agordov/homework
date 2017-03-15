package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessGame{

    public static char randomNumber(int lowerN, int higherN) {
        return (char)((new Random()).nextInt((higherN - lowerN) + 1) + lowerN);
    }

    public static void guessGame() {
        try {
            boolean flag = false;
            char in;
            String inputLine;
            char randChar = randomNumber('A', 'Z');
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            do {
                inputLine = bufferedReader.readLine();
                if (inputLine.isEmpty()) {
                    System.out.println("String can't be empty");
                }
                else {
                    in = inputLine.charAt(0);
                    if (in >= 'A' && in <= 'Z' && in == randChar) {
                        flag = true;
                    }
                    else if (in >= 'A' && in < randChar) {
                        System.out.println("Larger!");
                    }
                    else if (in <= 'Z' && in > randChar) {
                        System.out.println("Less!");
                    }
                }
            } while (!flag);
            System.out.println("Success!");
        }
        catch (IOException err) {
            System.err.println("Caught IOException " + err.getMessage());
        }
    }
    public static void main(String[] args){
        guessGame();
    }
}
