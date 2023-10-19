//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
//
// Related Topics 数学 双指针 二分查找 👍 441 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：平方数之和
public class P633SumOfSquareNumbers {

    @Test
    public void testResult() {
        Solution solution = new P633SumOfSquareNumbers().new Solution();        // TO TEST
        int c = 5;
        boolean actual = solution.judgeSquareSum(c);
        Assert.assertTrue(actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P633SumOfSquareNumbers().new Solution();        // TO TEST
        int c = 3;
        boolean actual = solution.judgeSquareSum(c);
        Assert.assertFalse(actual);
    }

    @Test
    public void testResult2() {
        Solution solution = new P633SumOfSquareNumbers().new Solution();        // TO TEST
        int c = 1;
        boolean actual = solution.judgeSquareSum(c);
        Assert.assertTrue(actual);
    }

    @Test
    public void testResult3() {
        Solution solution = new P633SumOfSquareNumbers().new Solution();        // TO TEST
        int c = 20;
        boolean actual = solution.judgeSquareSum(c);
        Assert.assertTrue(actual);
    }

    @Test
    public void testResult4() {
        Solution solution = new P633SumOfSquareNumbers().new Solution();        // TO TEST
        int c = 4;
        boolean actual = solution.judgeSquareSum(c);
        Assert.assertTrue(actual);
    }

    @Test
    public void testResult5() {
        Solution solution = new P633SumOfSquareNumbers().new Solution();        // TO TEST
        int c = 2147483600;
        boolean actual = solution.judgeSquareSum(c);
        Assert.assertTrue(actual);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            if (c == 0 || c == 1) {
                return true;
            }
            long i = 0, j = (long) Math.ceil(Math.sqrt(c));
            while (i <= j) {
                if (calcu(i, j) == c) {
                    return true;
                }else if (calcu(i, j) > c) {
                    j--;
                } else if (calcu(i, j) < c) {
                    i++;
                }
            }
            return false;
        }

        private long calcu(long i, long j) {
            return i * i + j * j;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

