package important.linked_list;


class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head;
    int length;

    public SinglyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {

        if (index >= length) return -1;
        int cur = 0;
        Node node = head;
        while (cur < index) {
            node = node.next;
            cur++;
        }
        if (index == 54) {
            Node n = head;
            while (n != null) {
                System.out.println(n.val);
                n = n.next;
            }
        }
        return node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.next = head;
        }

        head = node;
        length++;

    }

    public void addAtTail(int val) {
        Node node = new Node(val);

        if (head == null) head = node;
        else {
            Node curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        length++;

    }

    public void addAtIndex(int index, int val) {
        if (index > length) return;
        else if (index == 0) addAtHead(val);
        else if (index == length) addAtTail(val);
        else {
            Node node = new Node(val);
            int currentIndex = 0;
            Node currentNode = head;
            while (currentIndex < index - 1) {
                currentNode = currentNode.next;
                currentIndex++;
            }

            Node temp = currentNode.next;
            currentNode.next = node;
            node.next = temp;
            length++;
        }
    }

    public void deleteAtTail() {
        int curr = 0;
        Node node = head;
        while (curr < length - 2) {
            node = node.next;
            curr++;
        }

        node.next = null;
        length--;
    }

    public void deleteAtHead() {
        if (head == null) return;
        head = head.next;
        length--;
    }

    // 1,2,3,4,5

    public void deleteAtIndex(int index) {

        if (index >= length) return;
        else if (index == 0) deleteAtHead();
        else if (index == length - 1) deleteAtTail();
        else {
            int cur = 0;
            Node node = head;
            while (cur < index - 1) {
                node = node.next;
                cur++;
            }
            node.next = node.next.next;
            length--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
