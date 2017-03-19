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
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            char in;
            String inputLine;
            char randChar = randomNumber('A', 'Z');
            while (true) {
                inputLine = bufferedReader.readLine();
                if (inputLine.isEmpty()) {
                    System.out.println("String can't be empty");
                } else {
                    in = inputLine.charAt(0);
                    if (in >= 'A' && in <= 'Z') {
                        if (randChar < in) {
                            System.out.println("Less!");
                        } else if (randChar > in) {
                            System.out.println("Larger!");
                        } else {
                            System.out.println("Success!");
                            break;
                        }
                    } else {
                        System.out.println("Your symbol is out of borders");
                    }
                }
            }
        }
        catch (IOException err) {
            err.printStackTrace();
        }
    }
    public static void main(String[] args){
        guessGame();
    }
}
