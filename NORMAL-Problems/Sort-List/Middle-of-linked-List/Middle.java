/**
 * ==========================================================
 *    LEETCODE PROBLEM: MIDDLE OF THE LINKED LIST
 * ==========================================================
 * Given the head of a singly linked list, return the middle node.
 * If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * 
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * 
 * Approach:
 * - Use two pointers:
 *   1. `first` moves one step at a time.
 *   2. `second` moves two steps at a time.
 * - When `second` reaches the end, `first` will be at the middle.
 * 
 * Time Complexity: O(n) - We traverse the list once.
 * Space Complexity: O(1) - We use constant extra space.
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;  // Slow pointer
        ListNode second = head; // Fast pointer

        // Move `first` one step and `second` two steps until `second` reaches the end
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first; // `first` now points to the middle node
    }
}
