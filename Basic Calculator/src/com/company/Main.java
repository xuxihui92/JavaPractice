/*
Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
*/
package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        int result = calculate(s);
        System.out.println(result);
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        if(s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int sign = 1;
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            }else if(c != ' ') {
                switch (c) {
                    case ' ' :
                        break;
                    case '+' :
                        result += sign * number;
                        sign = 1;
                        break;
                    case '-' :
                        result += sign * number;
                        sign = -1;
                        break;
                    case '(' :
                        stack.push(result);
                        stack.push(sign);
                        sign = 1;
                        result = 0;
                        break;
                    case ')' :
                        result += sign * number;
                        result = result * stack.pop() + stack.pop();
                        break;
                    default :
                        throw new IllegalArgumentException();
                }
                number = 0;
            }
        }
        result += sign * number;
        return result;
    }
}
