//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：二叉搜索树的第k大节点
public class P剑指_offer_54ErChaSouSuoShuDeDiKdaJieDianLcof {

	@Test
	public void testResult() {
		Solution solution = new P剑指_offer_54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();        // TO TEST
		TreeNode node0 = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(1);
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node3.left = node5;
		int ret = solution.kthLargest(node0, 3);
		int expect = 4;
		Assert.assertEquals(expect, ret);
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		Stack<Integer> s = new Stack<>();

		public int kthLargest(TreeNode root, int k) {
			inOrder(root);
			int pop = -1;
			for (int i = 0; i < k; ++i) {
				pop = s.pop();
			}
			return pop;
		}

		private void inOrder(TreeNode root) {
			if (null != root) {
				inOrder(root.left);
				s.push(root.val);
				inOrder(root.right);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

