package com.vn.ds;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Vidya on 12/7/16.
 */
public class PossiblyCyclicalList<E> {
    private int size = 0;
    private Node<E> first = null;
    private Node<E> last = null;

    public PossiblyCyclicalList() {
    }

    public void add(E e) {
        Node<E> newNode = new Node(e, null);
        if (first == null) {
            first = newNode;
        }
        if (last != null) {
            last.setNext(newNode);
        }

        last = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public void cycleBackTo(int n) {
        if (n >= size || n < 0) {
            throw new IndexOutOfBoundsException("list size is " + size());
        }

        last.setNext(getNodeAt(n));
    }

    public boolean checkCycle() {
        Node<E> slow = first;
        Node<E> fast = first;

        for (int i = 0; i < size; i++) {
            if (fast == null) {
                return false;
            } else {
                fast = fast.getNext();
            }

            if (slow.getVal() == fast.getVal()) {
                return true;
            }
            slow = slow.getNext();

            if (fast == null) {
                return false;
            } else {
                fast = fast.getNext();
            }

        }
        return false;
    }


    public Node<E> getNodeAt(int n) {
        if (n >= size()) {
            throw new IndexOutOfBoundsException("list size is " + size());
        }
        Node<E> result = first;

        for (int i = 1; i < n; i++) {
            result = result.getNext();
        }
        return result;
    }


    public static class Node<E> {

        private Node<E> next;
        private E val;

        Node(E e, Node<E> next) {
            this.val = e;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

    }

    public void printList() {
        Node<E> n = first;
        for (int i = 0; i < size; i++) {
            System.out.print(i + "=" + n.getVal() + " ");
            n = n.getNext();
        }
        System.out.println("");
    }
}
