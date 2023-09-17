package important.linked_list;

public class MiddleNode {
    public ListNode middleNode(ListNode linkedList) {
        // Write your code here.

        if (linkedList.next == null) return linkedList;

        ListNode slow;
        ListNode fast;
        fast = linkedList;
        slow = linkedList;

        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;
    }
}
