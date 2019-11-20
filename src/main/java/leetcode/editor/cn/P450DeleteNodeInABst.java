//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树

package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

//Java：删除二叉搜索树中的节点
public class P450DeleteNodeInABst {

	@Test
	public void testResult() {
		Solution solution = new P450DeleteNodeInABst().new Solution();
		// TO TEST
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		TreeNode ret = solution.deleteNode(n1, 0);
		solution.LevelTraverse(ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P450DeleteNodeInABst().new Solution();
		// TO TEST
		TreeNode n1 = new TreeNode(0);
		TreeNode ret = solution.deleteNode(n1, 0);
		solution.LevelTraverse(ret);
	}

	@Test
	public void testResult3() {
		Solution solution = new P450DeleteNodeInABst().new Solution();
		// TO TEST
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.right = n2;
		TreeNode ret = solution.deleteNode(n1, 1);
		solution.LevelTraverse(ret);
	}

	@Test
	public void testResult4() {
		Solution solution = new P450DeleteNodeInABst().new Solution();
		// TO TEST
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		TreeNode ret = solution.deleteNode(n1, 2);
		solution.LevelTraverse(ret);
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
		private TreeNode parent = new TreeNode(-1);
		private boolean isRoot = false;
		private boolean notFound = false;

		public TreeNode deleteNode(TreeNode root, int key) {
			if (null == root) {
				return null;
			}
			findParent(root, key);
			judgePosition(root, key);
			if (notFound) {
				return root;
			}
			if (isRoot && null == root.left && null == root.right) {
				return null;
			}
			TreeNode cur;
			boolean isLeft = true;
			boolean flag = false;
			if (isRoot) {
				flag = true;
				cur = root;
				parent.left = root;
			} else if (null != parent.left && parent.left.val == key) {
				cur = parent.left;
			} else {
				cur = parent.right;
				isLeft = false;
			}
			if (null == cur.left && null == cur.right) {
				if (isLeft) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (null == cur.left) {
				if (isLeft) {
					parent.left = cur.right;
				} else {
					parent.right = cur.right;
				}
			} else if (null == cur.right) {
				if (isLeft) {
					parent.left = cur.left;
				} else {
					parent.right = cur.left;
				}
			} else {
				TreeNode temp = cur.right;
				TreeNode pre = cur;
				while (null != temp.left) {
					pre = temp;
					temp = temp.left;
				}
				if (isLeft) {
					parent.left.val = temp.val;
				} else {
					parent.right.val = temp.val;
				}
				if (pre.val == cur.val) {
					pre.right = temp.right;
				} else {
					pre.left = temp.right;
				}
			}
			if (flag) {
				return parent.left;
			}
			return root;
		}

		private void findParent(TreeNode root, int key) {
			if (null == root) {
				return;
			}
			if (root.val == key) {
				return;
			} else if (root.val < key) {
				parent = root;
				findParent(root.right, key);
			} else {
				parent = root;
				findParent(root.left, key);
			}
		}

		private void judgePosition(TreeNode root, int key) {
			if (null == parent.left && null == parent.right) {
				if (root.val == key) {
					isRoot = true;
				} else {
					notFound = true;
				}
			}
		}

		private void LevelTraverse(TreeNode root) {
			Queue<TreeNode> q = new LinkedList<>();
			if (null != root) {
				q.add(root);
			}
			while (!q.isEmpty()) {
				TreeNode top = q.poll();
				System.out.print(top.val + " ");
				if (null != top.left) {
					q.add(top.left);
				}
				if (null != top.right) {
					q.add(top.right);
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

