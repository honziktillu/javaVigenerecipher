package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    String value = "attackatdawn";
	    String klic = "lemon";

	    char[] cValue = value.toCharArray();
	    char[] cKlic = klic.toCharArray();

        int current = 0;
        int max = cKlic.length - 1;

        for (int i = 0; i < cValue.length; i++) {
            cValue[i] = cKlic[current];
            if (current == max) {
                current = 0;
            } else {
                current++;
            }
        }

        char[] m = new char[26];
        int minM = 0;
        int maxM = 25;
        for (int i = 10; i < 36; i++) {
            m[i - 10] = Character.forDigit(i, Character.MAX_RADIX);
        }
        char[] plaintext = value.toCharArray();
        char[] ciphertext = new char[plaintext.length];
        System.out.println(Arrays.toString(plaintext));
        System.out.println(Arrays.toString(cValue));
        for (int i = 0; i < cValue.length; i++) {
            System.out.println();
            int plaintextInt = Character.digit(plaintext[i], Character.MAX_RADIX) - 10;
            int keystreamInt = Character.digit(cValue[i], Character.MAX_RADIX) - 10;
            System.out.println("PlaintextInt: " + plaintextInt);
            System.out.println("keystreamInt: " + keystreamInt);
            int newChar = 0;
            if (keystreamInt + plaintextInt > 25) {
                int dif = keystreamInt + plaintextInt - 25;
                newChar = dif - 1;
            } else {
                newChar = keystreamInt + plaintextInt;
            }
            ciphertext[i] = m[newChar];
        }

        System.out.println(Arrays.toString(ciphertext));



    }
}
