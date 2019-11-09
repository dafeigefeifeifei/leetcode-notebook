//如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。 
//
// 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。 
//
// 返回使 S 单调递增的最小翻转次数。 
//
// 
//
// 示例 1： 
//
// 输入："00110"
//输出：1
//解释：我们翻转最后一位得到 00111.
// 
//
// 示例 2： 
//
// 输入："010110"
//输出：2
//解释：我们翻转得到 011111，或者是 000111。
// 
//
// 示例 3： 
//
// 输入："00011000"
//输出：2
//解释：我们翻转得到 00000000。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 中只包含字符 '0' 和 '1' 
// 
// Related Topics 数组

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

//Java：将字符串翻转到单调递增
public class P926FlipStringToMonotoneIncreasing {
	@Test
	public void testResult0() {
		Solution solution = new P926FlipStringToMonotoneIncreasing().new Solution();
		// TO TEST
		String S = "00110";
		int ret = solution.minFlipsMonoIncr(S);
		Assert.assertEquals(1, ret);
	}

	@Test
	public void testResult1() {
		Solution solution = new P926FlipStringToMonotoneIncreasing().new Solution();
		// TO TEST
		String S = "010110";
		int ret = solution.minFlipsMonoIncr(S);
		Assert.assertEquals(2, ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P926FlipStringToMonotoneIncreasing().new Solution();
		// TO TEST
		String S = "111011100100100";
		int ret = solution.minFlipsMonoIncr(S);
		Assert.assertEquals(7, ret);
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minFlipsMonoIncr(String S) {
			int[] dp = new int[S.length()]; // 脚标左侧（含脚标）1 的个数
			int count = 0;
			for (int i = 0; i < S.length(); ++i) {
				char c = S.charAt(i);
				if (c == '1') {
					count++;
				}
				dp[i] = count;
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i <= S.length(); ++i) {
				int left = i == 0 ? 0 : dp[i - 1];
				int right = i == 0 ? S.length() - dp[S.length() - 1] : (S.length() - i) - (dp[S.length() - 1] - dp[i - 1]);
				if (left + right < min) {
					min = left + right;
				}
			}
			return min;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}

