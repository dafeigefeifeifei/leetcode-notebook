//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：二叉树中的最大路径和
public class P124BinaryTreeMaximumPathSum {

	@Test
	public void testResult() {
		Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();        // TO TEST
		TreeNode node0 = new TreeNode(-10);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		node0.left = node1;
		node0.right = node2;
		node2.left = node3;
		node2.right = node4;
		int ret = solution.maxPathSum(node0);
		int expect = 42;
		Assert.assertEquals(expect, ret);
	}

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	class Solution {
		int max = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			getSingle(root);
			return max;
		}

		// 后序遍历统计单边，但 max 会记录左单边&右单边的最大和
		private int getSingle(TreeNode root) {
			if (null == root) {
				return 0;
			}
			int left = Math.max(0, getSingle(root.left));
			int right = Math.max(0, getSingle(root.right));
			max = Math.max(max, left + right + root.val);
			return Math.max(left, right) + root.val;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}

