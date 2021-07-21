//有一个由小写字母组成的字符串 S，和一个整数数组 shifts。 
//
// 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。 
//
// 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。 
//
// 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。 
//
// 返回将所有这些移位都应用到 S 后最终得到的字符串。 
//
// 示例： 
//
// 输入：S = "abc", shifts = [3,5,9]
//输出："rpl"
//解释： 
//我们以 "abc" 开始。
//将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
//再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
//最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
// 
//
// 提示： 
//
// 
// 1 <= S.length = shifts.length <= 20000 
// 0 <= shifts[i] <= 10 ^ 9 
// 
// Related Topics 数组 字符串 
// 👍 50 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;


//Java：字母移位
public class P848ShiftingLetters {

	@Test
	public void testResult() {
		Solution solution = new P848ShiftingLetters().new Solution();
		// TO TEST
		int[] shifts = {3, 5, 9};
		String abc = solution.shiftingLetters("abc", shifts);
		Assert.assertEquals("rpl", abc);
	}
	@Test
	public void testResult1() {
		Solution solution = new P848ShiftingLetters().new Solution();
		// TO TEST
		int[] shifts = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
		String abc = solution.shiftingLetters("mkgfzkkuxownxvfvxasy", shifts);
		Assert.assertEquals("wqqwlcjnkphhsyvrkdod", abc);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String shiftingLetters(String s, int[] shifts) {
			StringBuilder sb = new StringBuilder();
			int move = 0;
			for (int i = shifts.length - 1; i >= 0; --i) {
				char c = s.charAt(i);
				move += shifts[i] % 26;
				sb.append(remove(c, move));
			}
			return sb.reverse().toString();
		}

		private char remove(char pre, int carry) {
			int preN = pre - 'a';
			int now = (preN + carry) % 26;
			return (char) ('a' + now);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

