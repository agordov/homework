package homework;

import java.util.Random;

public class RandomNumber {

//    return highest digit of random three-digit number

    public static int randomNumber(int lowerN, int upperN) {
        if (lowerN > upperN) {
            int tmp = lowerN;
            lowerN = upperN;
            upperN = tmp;
        }
        return (new Random()).nextInt((upperN - lowerN) + 1) + lowerN;
    }

    public static char maxOfTwo(char a, char b) {
        return a > b ? a : b;
    }

    public static char maxDigit(int num) {
        char[] numArr = ("" + num).toCharArray();
        char max = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            max = maxOfTwo(max, numArr[i]);
        }
        return max;
    }

    public static void main(String... args) {
        int randN = randomNumber(100, 999);
        System.out.println(randN);
        System.out.println(maxDigit(randN));
    }
}
