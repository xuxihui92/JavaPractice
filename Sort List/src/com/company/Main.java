package com.company;

import java.util.Scanner;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // the number of input
        int N = input.nextInt();
        ListNode prev = new ListNode(input.nextInt());
        ListNode curr = prev;
        for (int i=1; i<N; i++) {
            prev.next = new ListNode(input.nextInt());
            prev = prev.next;
        }
        curr = sortList(curr);
        for (int i=0; i<N; i++){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // using two pointers to find the midpoint of list
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = sortList(slow.next);
        slow.next = null;

        return mergeTwoLists(sortList(head), secondhalf);
    }

    public static ListNode mergeTwoLists(ListNode leftlist, ListNode rightlist) {
        if (leftlist == null) {
            return rightlist;
        }
        if (rightlist == null) {
            return leftlist;
        }
        ListNode fakehead = new ListNode(Integer.MIN_VALUE);
        ListNode pointer = fakehead;
        while (leftlist != null && rightlist != null) {
            if (leftlist.val < rightlist.val) {
                pointer.next = leftlist;
                leftlist = leftlist.next;
            }else{
                pointer.next = rightlist;
                rightlist = rightlist.next;
            }
            pointer = pointer.next;
        }
        if (leftlist != null) {
            pointer.next = leftlist;
        }
        if (rightlist != null) {
            pointer.next = rightlist;
        }
        return fakehead.next;
    }
}
