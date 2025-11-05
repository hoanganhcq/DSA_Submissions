package BT4.LinkedList.Bai_8;
// Compare two linked lists

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

        public void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
    }
    
    public static int compare_lists(SinglyLinkedListNode llist1, SinglyLinkedListNode llist2) {
        while (llist1 != null && llist2 != null) {
            if (llist1.data != llist2.data) {
                return 0;
            }
            llist1 = llist1.next;
            llist2 = llist2.next;
        }


        if (llist1 != null || llist2 != null) {
            return 0;
        }

        return 1;  
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int t = 0; t < tests; t++) {
            
            SinglyLinkedList list1 = new SinglyLinkedList();
            int n1 = sc.nextInt();
            for (int i = 0; i < n1; i++) {
                list1.insertNode(sc.nextInt());
            }

            
            SinglyLinkedList list2 = new SinglyLinkedList();
            int n2 = sc.nextInt();
            for (int i = 0; i < n2; i++) {
                list2.insertNode(sc.nextInt());
            }

            
            System.out.println(compare_lists(list1.head, list2.head));
        }

        sc.close();
    }
}
