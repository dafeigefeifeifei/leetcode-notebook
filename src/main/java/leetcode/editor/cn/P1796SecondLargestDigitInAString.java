//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。 
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
// Related Topics 哈希表 字符串 
// 👍 2 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：字符串中第二大的数字
public class P1796SecondLargestDigitInAString {

	@Test
	public void testResult() {
		Solution solution = new P1796SecondLargestDigitInAString().new Solution();        // TO TEST
		int actual = solution.secondHighest("abc1111");
		Assert.assertEquals(-1, actual);
	}

	@Test
	public void testResult1() {
		Solution solution = new P1796SecondLargestDigitInAString().new Solution();        // TO TEST
		int actual = solution.secondHighest("dfa12321afd");
		Assert.assertEquals(2, actual);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int secondHighest(String s) {
			if (null == s || s.length() == 0) {
				return -1;
			}
			int largest = -1;
			int lower = -1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isAlphabetic(c)) {
					continue;
				}
				int x = Integer.parseInt(c + "");
				if (x > largest) {
					lower = largest;
					largest = x;
				} else if (x < largest) {
					lower = x > lower ? x : lower;
				}
			}
			return lower;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

