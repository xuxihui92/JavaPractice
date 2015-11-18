package com.company;
/*
This program is designed to return multiplication of the numbers as a string, given two numbers represented as strings
To test the result, two number are split by ","
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] in = input.nextLine().split(",");
        String num1 = in[0];
        String num2 = in[1];
        String product = multiply(num1, num2);
        System.out.println(product);
    }

    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] product = new int[n1 + n2];
        // compute product of each pair of digits
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j>=0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                product[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            int temp = (product[i] + carry) % 10;
            carry = (product[i] + carry) / 10;
            product[i] = temp;
        }
        // convert int[] to string
        StringBuilder sb = new StringBuilder();
        for (int num : product) {
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
