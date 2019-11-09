//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

//Java：反转链表 II
public class P92ReverseLinkedListIi {

	@Test
	public void testResult() {
		Solution solution = new P92ReverseLinkedListIi().new Solution();
		// TO TEST
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ListNode ret = solution.reverseBetween(n1, 2, 4);
		while (null != ret) {
			System.out.print(ret.val + " ");
			ret = ret.next;
		}
	}


//leetcode submit region begin(Prohibit modification and deletion)

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode root = new ListNode(0), cur = root;
			root.next = head;
			for (int i = 0; i < m - 1; ++i) {
				cur = cur.next;
			}
			head = cur;
			cur = cur.next;
			for (int i = m; i < n; ++i) {
				ListNode next = cur.next;
				cur.next = next.next;
				next.next = head.next;
				head.next = next;

			}
			return root.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

