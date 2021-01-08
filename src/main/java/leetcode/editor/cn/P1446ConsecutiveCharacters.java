//给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。 
//
// 请你返回字符串的能量。 
//
// 
//
// 示例 1： 
//
// 输入：s = "leetcode"
//输出：2
//解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
// 
//
// 示例 2： 
//
// 输入：s = "abbcccddddeeeeedcba"
//输出：5
//解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
// 
//
// 示例 3： 
//
// 输入：s = "triplepillooooow"
//输出：5
// 
//
// 示例 4： 
//
// 输入：s = "hooraaaaaaaaaaay"
//输出：11
// 
//
// 示例 5： 
//
// 输入：s = "tourist"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串 
// 👍 13 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：连续字符
public class P1446ConsecutiveCharacters {

	@Test
	public void testResult() {
		Solution solution = new P1446ConsecutiveCharacters().new Solution();
		// TO TEST
		int actual = solution.maxPower("hooraaaaaaaaaaay");
		Assert.assertEquals(11, actual);
	}

	@Test
	public void testResult2() {
		Solution solution = new P1446ConsecutiveCharacters().new Solution();
		// TO TEST
		int actual = solution.maxPower("tourist");
		Assert.assertEquals(1, actual);
	}

	@Test
	public void testResult3() {
		Solution solution = new P1446ConsecutiveCharacters().new Solution();
		// TO TEST
		int actual = solution.maxPower("abbcccddddeeeeedcba");
		Assert.assertEquals(5, actual);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxPower(String s) {
			int ret = 1;
			if (null == s) {
				return 0;
			}
			if (s.length() < 2) {
				return s.length();
			}
			int cnt = 1;
			for (int i = 1; i < s.length(); i++) {
				char c = s.charAt(i);
				char c0 = s.charAt(i - 1);
				if (c == c0) {
					cnt++;
					ret = Math.max(ret, cnt);
				} else {
					cnt = 1;
				}
			}
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

