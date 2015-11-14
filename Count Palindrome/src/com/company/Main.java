package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();

        // count the distinct palindrome
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str.substring(i, j))) {
                    set.add(str.substring(i, j));
                }
            }
        }

        System.out.println("All the distinct palindromes in this string: " + set);
        System.out.println("The number of distinct palindromes in this string: " + set.size());

        // count all of palindrome
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str.substring(i, j))) {
                    list.add(str.substring(i, j));
                }
            }
        }
        System.out.println("All the palindromes in this string " + list);
        System.out.println("The number of all palindromes in this string " + list.size());
    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 1 || s.length() == 0){
            return true;
        }
        int left = 0, right = s.length()-1;
        s = s.toLowerCase();

        while(left < right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else if(s.charAt(left) != s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
