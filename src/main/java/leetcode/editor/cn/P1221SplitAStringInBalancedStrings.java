//在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。 
//
// 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。 
//
// 返回可以通过分割得到的平衡字符串的最大数量。 
//
// 
//
// 示例 1： 
//
// 输入：s = "RLRRLLRLRL"
//输出：4
//解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
// 
//
// 示例 2： 
//
// 输入：s = "RLLLLRRRLR"
//输出：3
//解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
// 
//
// 示例 3： 
//
// 输入：s = "LLLLRRRR"
//输出：1
//解释：s 只能保持原样 "LLLLRRRR".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] = 'L' 或 'R' 
// 分割得到的每个字符串都必须是平衡字符串。 
// 
// Related Topics 贪心算法 字符串


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：分割平衡字符串
public class P1221SplitAStringInBalancedStrings {

	@Test
	public void testResult() {
		Solution solution = new P1221SplitAStringInBalancedStrings().new Solution();
		// TO TEST
		String s = "RLLLLRRRLR";
		int ret = solution.balancedStringSplit(s);
		int expect = 3;
		Assert.assertEquals(ret, expect);
	}
	@Test
	public void testResult2() {
		Solution solution = new P1221SplitAStringInBalancedStrings().new Solution();
		// TO TEST
		String s = "RLRRLLRLRL";
		int ret = solution.balancedStringSplit(s);
		int expect = 4;
		Assert.assertEquals(ret, expect);
	}
	@Test
	public void testResult3() {
		Solution solution = new P1221SplitAStringInBalancedStrings().new Solution();
		// TO TEST
		String s = "LLLLRRRR";
		int ret = solution.balancedStringSplit(s);
		int expect = 1;
		Assert.assertEquals(ret, expect);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int balancedStringSplit(String s) {
			int balance = 0;
			int cnt = 0;
			for (int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				if (c == 'L') {
					balance++;
				} else if (c == 'R') {
					balance--;
				}
				if (balance == 0) {
					++cnt;
				}
			}
			return cnt;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

