package com.ac.mylib.leetcode;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "" + val + "->" + next;
  }
}

public class Solution {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode value = new ListNode(0);
    ListNode cuur = value;
    ListNode p = l1;
    ListNode q = l2;
    int sum = 0;
    int carry = 0;
    while (p != null || q != null) {
      int x = p != null ? p.val : 0;
      int y = q != null ? q.val : 0;
      sum = carry + x + y;
      carry = sum / 10;
      cuur.next = new ListNode(sum % 10);
      cuur = cuur.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
      if (carry > 0) {
        cuur.next = new ListNode(carry);
      }
    }
    return value.next;
  }

  public static void main(String[] args) {
    //
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    l4.next = l3;
    ListNode l2 = new ListNode(2);
    l2.next = l4;

    ListNode l24 = new ListNode(4);
    ListNode l26 = new ListNode(6);
    l26.next = l24;
    ListNode l25 = new ListNode(5);
    l25.next = l26;

    System.out.println(l2);
    System.out.println(l25);
    System.out.println(addTwoNumbers(l2, l25));
  }
}
