package main;

import implementation.MyBinarySearchTree;

public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst
                = new MyBinarySearchTree<>();
        bst.insert(50);
        bst.insert(25);
        bst.insert(75);
        bst.insert(65);
        bst.insert(90);
        bst.insert(85);
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.delete(50);
        bst.inOrder(bst.getRoot());
    }
}
