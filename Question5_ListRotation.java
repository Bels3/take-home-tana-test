public class Question5_ListRotation {
    static class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
        }
    }

    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }

        // Count the number of nodes
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        // Connect end to head to form a circle
        temp.next = head;

        // Normalize n in case it's bigger than count
        n = n % count;
        int stepsToNewHead = count - n;

        // Move to the new tail
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewHead - 1; i++) {
            newTail = newTail.next;
        }

        // Break the circle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
//testing the functionality of the rotateRight method
    public static void main(String[] args) {
        ListNode head = new ListNode("ID_A01");
        head.next = new ListNode("ID_A02");
        head.next.next = new ListNode("ID_A03");
        head.next.next.next = new ListNode("ID_A04");
        head.next.next.next.next = new ListNode("ID_A05");
        head.next.next.next.next.next = new ListNode("ID_A06");

        System.out.println("Before rotation:");
        printList(head);

        ListNode rotated = rotateRight(head, 2);

        System.out.println("After rotating by 2:");
        printList(rotated);
    }
}
