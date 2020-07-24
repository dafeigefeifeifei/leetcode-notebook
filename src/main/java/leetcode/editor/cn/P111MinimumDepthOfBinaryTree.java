//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree {

	@Test
	public void testResult() {
		Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();        // TO TEST
		TreeNode node0 = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		node0.left = node1;
		node0.right = node2;
		node2.left = node3;
		node2.right = node4;
		int ret = solution.minDepth(node0);
		int expect = 2;
		Assert.assertEquals(expect, ret);
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public int minDepth(TreeNode root) {
			if (null == root) {
				return 0;
			}
			int deep = 1;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				int n = q.size();
				for (int i = 0; i < n; i++) {
					TreeNode top = q.poll();
					if (null == top.left && null == top.right) {
						return deep;
					}
					if (null != top.left) {
						q.add(top.left);
					}
					if (null != top.right) {
						q.add(top.right);
					}
				}
				++deep;
			}
			return -1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

