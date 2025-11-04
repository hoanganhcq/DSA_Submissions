package BT10.Bai_3;
// Binary Search Tree: Insertion
// https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
        
    	Node node = new Node(data);
        if (root == null) return node;
        
        Node curr = root;
        while (true) {
            if (data <= curr.data) {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = node;
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}