package important.linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
            if(head == null) return false;
            ListNode hare = head;
            ListNode tortoise = head;

            while(hare.next != null && tortoise.next != null && hare.next.next != null){
                tortoise = tortoise.next;
                hare = hare.next.next;

                if(hare == tortoise){
                    System.out.println(hare.val);
                    System.out.println(tortoise.val);
                    return true;
                }

            }

            return false;
        }
}
