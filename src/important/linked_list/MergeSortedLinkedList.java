package important.linked_list;

public class MergeSortedLinkedList {

    public static ListNode mergeListNodes(
            ListNode headOne, ListNode headTwo
    ) {

        ListNode node;
        ListNode res;

        if (headOne.val < headTwo.val) {
            node = headOne;
            headOne = headOne.next;
        } else {
            node = headTwo;
            headTwo = headTwo.next;
        }
        res = node;

        while (headOne != null && headTwo != null) {

            if (headOne.val < headTwo.val) {
                node.next = headOne;
                headOne = headOne.next;
            } else {
                node.next = headTwo;
                headTwo = headTwo.next;
            }

            node = node.next;


        }

        if (headOne != null) {
            node.next = headOne;
        } else {
            node.next = headTwo;
        }


        // Write your code here.
        return res;
    }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    ListNode node8 = new ListNode(8);
    ListNode node9 = new ListNode(9);
    ListNode node10 = new ListNode(10);

    node2.next = node6;
    node6.next = node7;
    node7.next = node8;


    //ListNode headTwo = node1;

    node1.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node9;
    node9.next = node10;

    System.out.println(node1.val);
    mergeListNodes(node2,node1);




  }
}
