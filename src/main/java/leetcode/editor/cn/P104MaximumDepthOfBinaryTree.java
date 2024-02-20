//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1778 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {

    @Test
    public void testResult() {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();        // TO TEST
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t3 = new TreeNode(3, t9, t20);
        int actual = solution.maxDepth(t3);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();        // TO TEST
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, null, t2);
        int actual = solution.maxDepth(t1);
        Assert.assertEquals(2, actual);
    }
    @Test
    public void testResult2() {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();        // TO TEST
        int actual = solution.maxDepth(null);
        Assert.assertEquals(0, actual);
    }
    @Test
    public void testResult3() {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();        // TO TEST
        TreeNode t2 = new TreeNode(2);
        int actual = solution.maxDepth(t2);
        Assert.assertEquals(1, actual);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            if (null == root.left && null == root.right) {
                return 1;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


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

