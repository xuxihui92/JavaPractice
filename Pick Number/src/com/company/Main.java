package com.company;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ArrayList<Integer> result = new ArrayList<>();
        result = pickNum(s);

        // pick up the digits in the string and sort them
        for(int i=0; i<result.size(); i++) {
            System.out.print(result.get(i));
        }
    }

    public static ArrayList<Integer> pickNum(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() > 65535){
            return res;
        }
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++) {
            if(Character.isDigit(c[i])) {
                res.add(c[i] - '0');
            }
        }
        Collections.sort(res);
        return res;
    }
}