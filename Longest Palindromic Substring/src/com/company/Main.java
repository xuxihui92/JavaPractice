/*
Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        String res = longestPalindrome(s);
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i-curr-1, i)) {
                res = s.substring(i-curr-1, i+1);
                curr = curr + 2;
            }else if (isPalindrome(s, i-curr, i)) {
                res = s.substring(i-curr, i+1);
                curr = curr + 1;
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start < 0) return false;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return  false;
            }
        }
        return true;
    }
}
