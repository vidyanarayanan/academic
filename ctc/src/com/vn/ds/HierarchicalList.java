package com.vn.ds;

/**
 * Created by Vidya on 12/8/16.
 */
public class HierarchicalList<E> {


    private HierarchicalNode<E> head;
    private HierarchicalNode<E> tail;


    public HierarchicalList() {
    }

    public HierarchicalNode<E> getHead() {
        return head;
    }

    public HierarchicalNode<E> getTail() {
        return tail;
    }


    public static class HierarchicalNode<E> {
        private HierarchicalNode<E> prev;
        private HierarchicalNode<E> next;
        private HierarchicalNode<E> child;
        private E value;


        private HierarchicalNode() {
        }

        public HierarchicalNode<E> getPrev() {
            return prev;
        }

        public void setPrev(HierarchicalNode<E> prev) {
            this.prev = prev;
        }

        public HierarchicalNode<E> getNext() {
            return next;
        }

        public void setNext(HierarchicalNode<E> next) {
            this.next = next;
        }

        public HierarchicalNode<E> getChild() {
            return child;
        }

        public void setChild(HierarchicalNode<E> child) {
            this.child = child;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

    }
}
