//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1117 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：加一
public class P66PlusOne {

    @Test
    public void testResult() {
        Solution solution = new P66PlusOne().new Solution();        // TO TEST
        int[] digits = {1, 2, 3};
        int[] expect = {1, 2, 4};
        int[] actual = solution.plusOne(digits);
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P66PlusOne().new Solution();        // TO TEST
        int[] digits = {4, 3, 2, 1};
        int[] expect = {4, 3, 2, 2};
        int[] actual = solution.plusOne(digits);
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testResult2() {
        Solution solution = new P66PlusOne().new Solution();        // TO TEST
        int[] digits = {0};
        int[] expect = {1};
        int[] actual = solution.plusOne(digits);
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void testResult3() {
        Solution solution = new P66PlusOne().new Solution();        // TO TEST
        int[] digits = {9, 9, 9, 9};
        int[] expect = {1, 0, 0, 0, 0};
        int[] actual = solution.plusOne(digits);
        Assert.assertArrayEquals(expect, actual);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int length = digits.length;
            int carry = 1;
            for (int i = 0; i < length; i++) {
                int j = length - i - 1;
                int num = digits[j] + carry;
                if (num == 10) {
                    digits[j] = 0;
                    carry = 1;
                } else {
                    digits[j] = num;
                    carry = 0;
                }
                if (i == length - 1 && carry > 0) {
                    int[] ret = new int[digits.length + 1];
                    ret[0] = 1;
                    return ret;
                }
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

