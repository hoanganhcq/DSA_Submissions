package BT4.LinkedList.Bai_9;
// Merge two sorted linked lists

import java.io.*;
import java.util.*;

public class Solution {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
    }
    
    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, 
                                                  SinglyLinkedListNode headB) 
    {
        if (headA == null) return headB;
        if (headB == null) return headA;

        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummy;

        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }

        
        if (headA != null) tail.next = headA;
        if (headB != null) tail.next = headB;

        return dummy.next;
    }

    public static void printList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int t = 0; t < tests; t++) {
            // First list
            SinglyLinkedList list1 = new SinglyLinkedList();
            int n1 = sc.nextInt();
            for (int i = 0; i < n1; i++) {
                list1.insertNode(sc.nextInt());
            }

            // Second list
            SinglyLinkedList list2 = new SinglyLinkedList();
            int n2 = sc.nextInt();
            for (int i = 0; i < n2; i++) {
                list2.insertNode(sc.nextInt());
            }

            // Merge lists
            SinglyLinkedListNode mergedHead = mergeLists(list1.head, list2.head);

            // Print result
            printList(mergedHead);
        }

        sc.close();
    }
}
