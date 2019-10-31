//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// A.length >= 3 
// 在 0 < i < A.length - 1 条件下，存在 i 使得：
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[B.length - 1] 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：[2,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：[3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// 
//
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.*;

//Java：有效的山脉数组
public class P941ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new P941ValidMountainArray().new Solution();
        // TO TEST
        int[] A = {4, 2, 1};
        boolean ret = solution.validMountainArray(A);
        System.out.println(ret);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] A) {
            int carry = -1;
            int symbol = 1;
            for (int i = 0; i < A.length; ++i) {
                int cur = A[i];
                if (cur - carry == 0) {
                    return false;
                } else if (symbol * (cur - carry) < 0) { // symbol 变向
                    symbol = -2 * symbol;
                    if (i == 1) {
                        return false; // 如果山峰在最左，直接返回 false
                    }
                }
                carry = cur;
            }
            if (symbol == -2) {
                return true; // 说明上文的 symbol = -2 * symbol 只允许单次进入
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}