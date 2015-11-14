/*
Given a string, divide them into several groups based on the special character and pick up the specific group
For example:
Input: aaa?bbb?ccc?ddd??3
Output: ccc
Commend: The last character is the number of group you want to pick up, The '?' is the character used to split.
*/

package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = reader.nextLine();
        String result = divString(s);
        System.out.println(result);
    }

    public static String divString(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        int n = s.length();
        char splt = s.charAt(n - 2);
        int num = s.charAt(n - 1) - '0';
        char[] c = s.substring(0, n - 2).toCharArray();

        // ind1 is used to record first character of substring
        int ind1 = 0;
        ArrayList<String> result = new ArrayList<String>();

        for(int i=0; i<c.length; i++) {
            if(c[i] == splt) {
                result.add(s.substring(ind1, i));
                ind1 = i + 1;
            }
        }

        int N = result.size();
        // System.out.println(N);
        // System.out.println(num);
        if(N < num) {
            return null;
        }else{
            return result.get(num - 1);
        }
    }
}
