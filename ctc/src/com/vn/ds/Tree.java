package com.vn.ds;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Vidya on 12/8/16.
 */
public class Tree<E> {
    private Node<E> head;

    public Tree(Node<E> node) {
        this.head = node;
    }

    public int getNumChildren() {
        return head.getNumChildren();
    }

    public Node<E> getHead() {
        return head;
    }


    public static class Node<E> {

        ArrayList<Node> children = new ArrayList<Node>();
        E val;

        public int getNumChildren() {
            return children.size();
        }

        public Collection getChildren() {
            return children;
        }

        public void addChild(Node<E> node) {
            children.add(node);
        }

        public Node<E> getChildAt(int i) {
            if (i < 0 || i >= children.size()) {
                throw new IndexOutOfBoundsException("No child found ");
            }
            return children.get(i);
        }

        public Node(E val) {
            this.val = val;
        }

        public E getValue() {
            return val;
        }

    }


    public static void main(String args[]) {

        Tree.Node<Integer> node = new Tree.Node(10);
        Tree<Integer> tree = new Tree(node);
        Tree.Node<Integer> n2 = new Tree.Node(20);
        Tree.Node<Integer> n3 = new Tree.Node(30);
        Node<Integer> head = tree.getHead();
        head.addChild(n2);
        head.addChild(n3);

        Tree.Node<Integer> n4 = new Tree.Node(40);
        Tree.Node<Integer> n5 = new Tree.Node(50);

        ArrayList<Node> narray = new ArrayList<Node>();
        n2.addChild(n4);
        n4.addChild(n5);

        tree.printTree();
    }


    public void printTree() {
        if (this.head != null) {
            printNode(head);
        } else {
            System.out.println("Empty tree");
        }
    }

    public void printNode(Node<E> node) {
        if (node != null) {
            System.out.print(node.getValue());

            for (Node n : node.children) {
                printNode(n);
            }
        }
    }
}
