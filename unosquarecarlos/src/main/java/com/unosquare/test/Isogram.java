package com.unosquare.test;

import java.util.Arrays;

public class Isogram {
    static boolean isIsogram(String strIsogram){
        strIsogram = strIsogram.toLowerCase();
        int len = strIsogram.length();

        char arr[] = strIsogram.toCharArray();

        Arrays.sort(arr);
        for (int i = 0; i < len - 1; i++){
            if(arr[i] == arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * IsIsogram("Algorism") ➞ true
         * IsIsogram("PasSword") ➞ false
         * // Not case sensitive.
         * IsIsogram("Consecutive")
         */

        String[] words = {"Algorism","PasSword","Consecutive"};

        for (String word: words) {
            System.out.println(isIsogram(word));
        }
    }
}
