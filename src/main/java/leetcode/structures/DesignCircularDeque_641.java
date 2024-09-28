package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.09.2024
 **/
public class DesignCircularDeque_641 {

    Node head;
    Node rear;
    int size;
    int capacity;

    public DesignCircularDeque_641(final int k) {
        size = 0;
        capacity = k;
    }

    public static void main(String[] args) {

    }

    public boolean insertFront(final int value) {
        if (isFull()) return false;
        if (head == null) {
            rear = head = new Node(value, null, null);
        } else {
            // add new head
            head.prev = new Node(value, null, head);
            head = head.prev;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (head == null) {
            // first element in list
            head = new Node(value, null, null);
            rear = head;
        } else {
            // add new element to end
            rear.next = new Node(value, rear, null);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = null;
            rear = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = null;
            rear = null;
        } else {
            // update rear to the previous node
            rear = rear.prev;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return rear.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
