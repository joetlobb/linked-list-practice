public class Exercises {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(1);

        System.out.println("ListNode sum: " + sum(head));

        head = new ListNode(4);
        head.next = new ListNode(-6);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(8);

        System.out.println("ListNode countNegative: " + countNegative(head));

        addToEnd(head, 99);
        ListNode current = head;
        System.out.print("ListNode addToEnd: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            if (current.next == null) {
                System.out.print("null");
                break;
            }
            current = current.next;
        }
        System.out.println();

        makePositive(head);
        current = head;
        System.out.print("ListNode makePositive: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            if (current.next == null) {
                System.out.print("null");
                break;
            }
            current = current.next;
        }
        System.out.println();

        head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(15);

        System.out.println("ListNode isIncreasing: " + isIncreasing(head));

    }

    /**
     * Returns the sum of the values in the linked list.
     * 
     * Returns 0 if head is null.
     * 
     * Example:
     * input: 4 -> 2 -> 10 -> 1
     * output: 17
     * 
     * @param head the head of the linked list
     * @return sum of the values in the list
     */
    public static int sum(ListNode head) {
        ListNode current = head;
        int sum = 0;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    /**
     * Returns how many negative values there are in the linked list.
     * 
     * Returns 0 if the head is null.
     * 
     * Example:
     * input: 4 -> -6 -> 7 -> -3 -> 8
     * output: 2
     * 
     * @param head the head of the linked list
     * @return a count of the negative values in the list
     */
    public static int countNegative(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            if (current.data < 0) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    /**
     * Adds a new ListNode with the given value to the end of the linked list.
     * 
     * If head is null, no action is taken.
     * 
     * Example:
     * head: 8 -> 3 -> 2 -> 7
     * toAdd: 99
     * 
     * result: 8 -> 3 -> 2 -> 7 -> 99
     * 
     * @param head the head of the list
     * @param toAdd the value to append in a new node
     */
    public static void addToEnd(ListNode head, int toAdd) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                current.next = new ListNode(toAdd);
                return;
            }
            current = current.next;
        }
    }

    /**
     * Modifies the list to make all negative values positive.
     * 
     * Positive and zero values are left unchanged.
     * If head is null, no action is taken.
     * 
     * Example:
     * head: -4 -> 7 -> -8 -> 6 -> -2
     * result: 4 -> 7 -> 8 -> 6 -> 2
     * 
     * @param head the head of the list
     */
    public static void makePositive(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.data < 0) {
                current.data = Math.abs(current.data);
            }
            current = current.next;
        }
    }

    /**
     * Returns true if every value in the list is less than or equal to the next
     * value in the list and false otherwise.
     * 
     * Returns true if head is null or there is only one value in the list.
     * 
     * Examples:
     * input: 3 -> 7 -> 7 -> 12 -> 15
     * output: true
     * 
     * input: 3 -> 1 -> 7 -> 9
     * output: false
     * 
     * @param head the head of the list
     * @return whether the list is increasing
     */
    public static boolean isIncreasing(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode current = head;
        while (current != null) {
            if (current.next != null) {
                if (current.data > current.next.data) {
                    return false;
                }
            }
            current = current.next;
        }
        return true;
    }
}
