//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1943 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {

    @Test
    public void testResult() {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();        // TO TEST
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        List<Integer> actualList = solution.inorderTraversal(node1);
        Integer[] actual = actualList.toArray(new Integer[0]);
        Integer[] expect = {1, 3, 2};
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();        // TO TEST
        List<Integer> actualList = solution.inorderTraversal(null);
        Integer[] actual = actualList.toArray(new Integer[0]);
        Integer[] expect = {};
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testResult2() {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();        // TO TEST
        TreeNode node1 = new TreeNode(1);
        List<Integer> actualList = solution.inorderTraversal(node1);
        Integer[] actual = actualList.toArray(new Integer[0]);
        Integer[] expect = {1};
        Assert.assertArrayEquals(expect, actual);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            inorder(ret, root);
            return ret;
        }

        private void inorder(List<Integer> ret, TreeNode root) {
            if (null == root) {
                return;
            }
            inorder(ret, root.left);
            ret.add(root.val);
            inorder(ret, root.right);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

