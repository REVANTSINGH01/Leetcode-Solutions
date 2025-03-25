/**
 *    LEETCODE PROBLEM: INTERSECTION OF TWO LINKED LISTS 
 *
 * Given the heads of two singly linked lists, return the node where the two lists intersect.
 * If the two linked lists have no intersection, return null.
 *
 * Example 1:
 * Input: 
 * A: [4,1,8,4,5], B: [5,6,1,8,4,5]
 * Output: Reference of the node with value = 8
 *
 * Example 2:
 * Input: 
 * A: [2,6,4], B: [1,5]
 * Output: null
 *
 * Constraints:
 * - The number of nodes in each list is in the range [0, 10^4].
 * - -10^5 <= Node.val <= 10^5
 * - It is guaranteed that there are no cycles in the list.
 * - The lists may intersect at one node or may not intersect at all.
 *
 * Approach:
 * - Use two pointers, `a` and `b`, starting from `headA` and `headB` respectively.
 * - If either pointer reaches the end of its list, redirect it to the other list’s head.
 * - Continue until both pointers meet at the intersection node or both become null.
 * - This works because both pointers traverse the same combined length.
 *
 * Time Complexity: O(N + M) - N and M are the lengths of the two lists.
 * Space Complexity: O(1) - Constant space.
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists, switching to the other list when null is reached
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Return the intersection node or null if no intersection
        return a;
    }
}
