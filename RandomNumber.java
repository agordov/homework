package homework;

import java.util.Random;

public class RandomNumber {

//    return highest digit of random three-digit number

    public static int randomNumber(int lowerN, int higherN) {
        return (new Random()).nextInt((higherN - lowerN) + 1) + lowerN;
    }

    public static int randomNumberMax(int lowerN, int higherN) {
        int randN = randomNumber(lowerN, higherN);
        System.out.println(randN);
        int a = randN % 10;
        randN /= 10;
        int b = randN % 10;
        randN /= 10;
        int c = randN % 10;
        return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
    }

    public static void main(String... args) {
        System.out.println(randomNumberMax(100, 999));
    }
}
