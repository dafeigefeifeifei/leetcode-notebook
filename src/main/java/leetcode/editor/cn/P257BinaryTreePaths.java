//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1049 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

//Java：二叉树的所有路径
public class P257BinaryTreePaths {

    @Test
    public void testResult() {
        Solution solution = new P257BinaryTreePaths().new Solution();        // TO TEST
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        List<String> ret = solution.binaryTreePaths(root);
        for (String s : ret) {
            System.out.println(s);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        List<String> ret = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (null == root) {
                return null;
            }
            List<Integer> carry = new ArrayList<>();
            reverse(carry, root);
            return ret;
        }

        private void reverse(List<Integer> carry, TreeNode root) {
            if(null == root){
                return;
            }
            carry.add(root.val);
            if (null == root.left && null == root.right) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < carry.size(); i++) {
                    if (i != 0) {
                        str.append("->");
                    }
                    str.append(carry.get(i));
                }
                ret.add(str.toString());
            }
            reverse(carry, root.left);
            reverse(carry, root.right);
            carry.remove(carry.size() - 1);
        }

    }


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
//leetcode submit region end(Prohibit modification and deletion)

}

