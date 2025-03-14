/**
 *    LEETCODE PROBLEM: REVERSE LINKED LIST 
 *
 * Given the head of a singly linked list, reverse the list and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Approach:
 * - Use three pointers: `prev`, `curr`, and `next`.
 * - Iterate through the list, reversing each node's `next` pointer.
 * - Return the new head (previously the last node).
 *
 * Time Complexity: O(N) - We traverse the list once.
 * Space Complexity: O(1) - We use only a few extra pointers.
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
