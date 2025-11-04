package BT9.Bai_4;
// Tree: Inorder Traversal
// https://www.hackerrank.com/challenges/tree-inorder-traversal/problem

import java.io.*;
import java.util.*;


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;

        for (int i = 0; i < t; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        inOrder(root);
        sc.close();
    }
}
