package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 5, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        int res = longestConsec(nums);
        System.out.println(result);
        System.out.println(res);
    }
    /*
    O(nlogn) solution
    First sort array and then count the consecutive numbers
    Return the maximum result
    * */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int maxCount = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue; // skip the duplicate
            } else if (nums[i] + 1 == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            maxCount = (count > maxCount) ? count : maxCount;
        }
        return maxCount;
    }
    /*
    O(n) solution
    Use HashSet function
    * */
    public static int longestConsec(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxCount = 1;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            int left = n - 1;
            int right  = n + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
