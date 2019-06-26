package com.crypto;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private Character cs;
    private Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        this.cs = 'a';
        this.cf = 'a' + 13;

    }


    public String crypt(String text) throws UnsupportedOperationException {
        String crypted = "";
        for (int i=0; i<text.length(); i++) {
            char textChar = text.charAt(i);
            int shiftDifference = 13;
            int diffFromLastChar = 0;
            if (textChar >= 'a' && textChar <= 'z') {
                diffFromLastChar = 'z' - textChar;
                if (diffFromLastChar > shiftDifference) {
                    textChar += shiftDifference;
                } else {
                    textChar = 'a';
                    textChar += (shiftDifference - diffFromLastChar - 1);
                }

            }
            else if (textChar >= 'A' && textChar <= 'Z') {
                diffFromLastChar = 'Z' - textChar;
                if (diffFromLastChar > shiftDifference) {
                    textChar += shiftDifference;
                } else {
                    textChar = 'A';
                    textChar += (shiftDifference - diffFromLastChar - 1);
                }

            }
            crypted += textChar;

        }
        return crypted;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {

        char lastChar = s.charAt(s.length()-1);
        String rotated = "";
        for (int i=0; i<s.length(); i++) {
            char textChar = s.charAt(i);
            int shiftDifference = c - 'A';
            int diffFromLastChar = lastChar - textChar;
            if (diffFromLastChar >= shiftDifference) {
                textChar += shiftDifference;
            } else {
                textChar = 'A';
                textChar += (shiftDifference - diffFromLastChar - 1);
            }
            rotated += textChar;
        }

        return rotated;
    }

}
