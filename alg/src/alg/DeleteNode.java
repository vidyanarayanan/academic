package alg;

/**
 * Created by Vidya on 12/17/16.
 * Delete a node given access just to the node
 */
public class DeleteNode {

    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            throw new RuntimeException("Cannot delete tail node");
        }
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        ListNode n = one;

        System.out.println("Before delete");
        while(n != null) {
            System.out.print(n.val + "->");
            n = n.next;
        }

        deleteNode(one);

        System.out.println("\nAfter delete");
        n = one;
        while(n != null) {
            System.out.print(n.val + "->");
            n = n.next;
        }
    }

}
