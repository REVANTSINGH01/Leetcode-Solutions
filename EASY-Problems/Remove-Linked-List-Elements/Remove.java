/**
 * ========================================================
 * LeetCode Problem: Remove Linked List Elements
 * ========================================================
 *
 * Given the head of a linked list and an integer `val`, remove all the nodes
 * of the linked list that have `Node.val == val`, and return the new head.
 *
 * Approach:
 * - First, remove any leading nodes with value equal to `val`.
 * - Then use two pointers: `prev` and `curr` to traverse the list.
 * - If `curr.val == val`, skip the node by setting `prev.next = curr.next`.
 * - Otherwise, move both pointers forward.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Step 1: Skip leading nodes with value == val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // If list becomes empty after removing leading nodes
        if (head == null) return null;

        // Step 2: Initialize pointers
        ListNode prev = head;
        ListNode curr = head.next;

        // Step 3: Traverse and remove nodes with value == val
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next; // Remove current node
            } else {
                prev = curr; // Move prev forward if no deletion
            }
            curr = curr.next;
        }

        return head;
    }
}
