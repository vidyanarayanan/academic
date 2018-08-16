package com.vn.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/**
 * Created by Vidya on 12/8/16.
 */
public class BinaryTree<E> {
    private BinaryNode<E> head;

    public BinaryTree(BinaryNode<E> node) {
        this.head = node;
    }


    public BinaryNode<E> getHead() {
        return head;
    }


    public static class BinaryNode<E> {

        BinaryNode<E> left;
        BinaryNode<E> right;
        E val;

        public BinaryNode(E val) {
            if (val == null) {
                throw new IllegalArgumentException("Binary Node must contain a non-null value");
            }
            this.val = val;
        }


        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public BinaryNode<E> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<E> left) {
            this.left = left;
        }

        public BinaryNode<E> getRight() {
            return right;
        }

        public void setRight(BinaryNode<E> right) {
            this.right = right;
        }

    }


    public static void main(String args[]) {

        BinaryTree.BinaryNode<Integer> node = new BinaryTree.BinaryNode(40);
        BinaryTree<Integer> tree = new BinaryTree(node);

        BinaryTree.BinaryNode<Integer> n1 = new BinaryTree.BinaryNode(10);
        BinaryTree.BinaryNode<Integer> n2 = new BinaryTree.BinaryNode(20);
        BinaryTree.BinaryNode<Integer> n3 = new BinaryTree.BinaryNode(30);
        BinaryTree.BinaryNode<Integer> n5 = new BinaryTree.BinaryNode(50);
        BinaryTree.BinaryNode<Integer> n6 = new BinaryTree.BinaryNode(60);
        BinaryTree.BinaryNode<Integer> n7 = new BinaryTree.BinaryNode(70);

        BinaryNode<Integer> head = tree.getHead();
        head.setLeft(n2);
        head.setRight(n6);

        n2.setLeft(n1);
        n2.setRight(n3);
        n6.setLeft(n5);
        n6.setRight(n7);
        tree.printTree();
    }


    public void printTree() {
        if (this.head != null) {
            printNode(head);
        } else {
            System.out.println("Empty tree");
        }
    }

    public void printNode(BinaryNode<E> node) {
        if (node != null) {
            if (node.getLeft() != null) {
                printNode(node.getLeft());
            }
            System.out.println(node.getVal());
            if (node.getLeft() != null) {
                printNode(node.getRight());
            }
        }
    }


    public void printPreOrderNonRecursively() {
        if (this.head != null) {
            Stack<BinaryNode> stack = new Stack<BinaryNode>();

            stack.push(head);
            while (stack.size() > 0) {
                BinaryNode<E> node = stack.pop();
                System.out.println(node.getVal());
                BinaryNode<E> right = node.getRight();
                if (right != null) { stack.push(right);}
                BinaryNode<E> left = node.getLeft();
                if (left != null) { stack.push(left);}
            }

        } else {
            System.out.println("Empty tree");
        }

    }
}
