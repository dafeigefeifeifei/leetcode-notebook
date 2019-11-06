//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	@Test
	public void testResult() {
		Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
		// TO TEST
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		TreeNode root = solution.buildTree(preorder, inorder);
		Assert.assertEquals(3, root.val);
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
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
		}

		private TreeNode buildTree(int[] preorder, int[] inorder, int lpre, int rpre, int lin, int rin) {
			if (lpre > rpre) {
				return null;
			} else if (lpre == rpre) {
				TreeNode cur = new TreeNode(preorder[lpre]);
				cur.left = null;
				cur.right = null;
				return cur;
			}
			int inPos = findInPos(preorder, inorder, lpre, lin, rin);
			int left = inPos - lin; // 左子树结点数
			TreeNode cur = new TreeNode(preorder[lpre]);
			cur.left = buildTree(preorder, inorder, lpre + 1, lpre + left, lin, inPos - 1);
			cur.right = buildTree(preorder, inorder, lpre + left + 1, rpre, inPos + 1, rin);
			return cur;
		}

		private int findInPos(int[] preorder, int[] inorder, int lpre, int lin, int rin) {
			for (int i = lin; i <= rin; ++i) {
				if (inorder[i] == preorder[lpre]) {
					return i;
				}
			}
			return -1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}