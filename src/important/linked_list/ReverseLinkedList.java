package important.linked_list;

/**
 1->2->3->4->5
 2->3->4->5
 3->4->5
 4->5  ->
 5

 * **/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;

        if (head.next == null) return head;


        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;


        return node;
    }
}
