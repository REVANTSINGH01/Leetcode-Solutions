/**
 *    LEETCODE PROBLEM: REMOVE DUPLICATES FROM SORTED LIST 
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * Approach:
 * - Use a pointer `curr` to traverse the list.
 * - If `curr.val == curr.next.val`, skip the duplicate node by updating `curr.next`.
 * - Otherwise, move `curr` forward.
 * - Return the modified linked list.
 *
 * Time Complexity: O(N) - We traverse the list once.
 * Space Complexity: O(1) - We modify the list in place without extra space.
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if (curr != null && curr.next == null) {
            return head;
        }
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
