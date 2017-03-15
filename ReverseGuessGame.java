package homework;

import java.util.Scanner;

public class ReverseGuessGame {

    public static void printNum(int num) {
        System.out.println("Your number is " + num);
        System.exit(0);
    }

    public static void reverseGuessGame(int leftB, int rightB) {
        if (leftB == rightB) {
            printNum(rightB);
        }
        int middle = (leftB + rightB) / 2;
        System.out.println(leftB + " " + middle + " " + rightB);
        System.out.println("Is you number more than " + middle + "?");
        Scanner reader = new Scanner(System.in);
        String inLine;
        inLine = reader.nextLine();
        if (inLine.startsWith("n"))
        {
            if (rightB - leftB == 1) {
                printNum(leftB);
            }
            rightB = middle;
            reverseGuessGame(leftB, rightB);
        }
        else
        {
            if (rightB - leftB == 1) {
                printNum(rightB);
            }
            leftB = middle + 1;
            reverseGuessGame(leftB, rightB);
        }
    }

    public static void main(String... args) {
        Scanner reader = new Scanner(System.in);
        int leftB, rightB;
        System.out.println("Input game borders");
        leftB = reader.nextInt();
        rightB = reader.nextInt();
        if (rightB < leftB) {
            int tmp = rightB;
            rightB = leftB;
            leftB = tmp;
        }
        reverseGuessGame(leftB, rightB);
    }
}
