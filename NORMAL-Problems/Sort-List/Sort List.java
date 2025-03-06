/**
 *         PROBLEM: SORT LIST
 *
 * Given the head of a linked list, sort it in ascending 
 * order using the Merge Sort algorithm.
 *
 * Example:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Time Complexity: O(n log n) - Merge Sort 
 * Space Complexity: O(log n) - Recursion stack space
 */

class Solution {
    public ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);  // Dummy node to simplify merging
        ListNode temp = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        
        // Attach remaining nodes from list1 or list2
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;
        
        return dummy.next;
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;  // Slow pointer gives the middle node
    }
  
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // Base case: List with 0 or 1 node is already sorted
        }

        // Step 1: Find middle node
        ListNode mid = findMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null;  // Split the list into two halves

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Step 3: Merge the sorted halves
        return mergeSortedLists(left, right);
    }
}
