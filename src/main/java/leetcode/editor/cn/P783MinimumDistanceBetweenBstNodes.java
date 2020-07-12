//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归


package leetcode.editor.cn;

import apple.laf.JRSUIUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：二叉搜索树节点最小距离
public class P783MinimumDistanceBetweenBstNodes {

	@Test
	public void testResult() {
		Solution solution = new P783MinimumDistanceBetweenBstNodes().new Solution();        // TO TEST
		TreeNode node0 = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		int ret = solution.minDiffInBST(node0);
		int expect = 1;
		Assert.assertEquals(expect, ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P783MinimumDistanceBetweenBstNodes().new Solution();        // TO TEST
		TreeNode node0 = new TreeNode(1);
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(48);
		TreeNode node3 = new TreeNode(12);
		TreeNode node4 = new TreeNode(49);
		node0.left = node1;
		node0.right = node2;
		node2.left = node3;
		node2.right = node4;
		int ret = solution.minDiffInBST(node0);
		int expect = 1;
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
		int pre = 0, min = Integer.MAX_VALUE;
		boolean first = false;

		public int minDiffInBST(TreeNode root) {
			inOrder(root);
			return min;
		}

		private void inOrder(TreeNode root) {
			if (null != root) {
				inOrder(root.left);
				if (first) {
					// 中序遍历的第一个节点不计算 diff
					int diff = root.val - pre;
					min = Math.min(min, diff);
				}
				pre = root.val;
				first = true;
				inOrder(root.right);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

