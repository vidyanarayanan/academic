package com.vn;

/**
 * Created by Vidya on 12/6/16.
 */
public class LinkedListVN<E> {

    transient int size;
    private Node<E> first;
    private Node<E> last;

    public int size() {
        return size;
    }

    public LinkedListVN() {
    }

    public void linkFirst(E e) {
        final Node<E> f = first;
        Node<E> newFirst = new Node(null, e, f);
        first = newFirst;


        if (f == null) {
            last = newFirst;
        } else {
            f.prev = newFirst;
        }

        size++;
    }


    public void linkLast(E e) {
        final Node<E> l = last;
        Node<E> newLast = new Node(l, e,null);
        first = newLast;


        if (l == null) {
            first = newLast;
        } else {
            l.next = newLast;
        }

        size++;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }


}
