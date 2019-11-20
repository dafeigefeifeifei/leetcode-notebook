//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]. 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：字母板上的路径
public class P1138AlphabetBoardPath {

	@Test
	public void testResult() {
		Solution solution = new P1138AlphabetBoardPath().new Solution();
		// TO TEST
		String target = "leet";
		String ret = solution.alphabetBoardPath(target);
		Assert.assertEquals("DDR!UURRR!!DDD!", ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P1138AlphabetBoardPath().new Solution();
		// TO TEST
		String target = "code";
		String ret = solution.alphabetBoardPath(target);
		Assert.assertEquals("RR!DDRR!UUL!R!", ret);
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String alphabetBoardPath(String target) {
			String temp = 'a' + target;
			StringBuilder ret = new StringBuilder();
			for (int i = 0; i < temp.length() - 1; ++i) {
				ret.append(calcu(temp.charAt(i), temp.charAt(i + 1)));
			}
			return ret.toString();
		}

		// 计算两个字符之间的步数
		private String calcu(char start, char end) {
			StringBuilder sb = new StringBuilder();
			int ss = start - 'a';
			int ee = end - 'a';
			int sX = ss / 5;
			int sY = ss % 5;
			int eX = ee / 5;
			int eY = ee % 5;
			if (sX == 5 && eX == 5) {
				sb.append("!");
			} else if (sX == 5) {
				sb.append("U").append(calcu('u', end));
			} else if (eX == 5) {
				sb.append(calcu(start, 'u')).deleteCharAt(sb.length() - 1).append("D!");
			} else {
				while (sX < eX) {
					sb.append('D');
					sX++;
				}
				while (sX > eX) {
					sb.append('U');
					sX--;
				}
				while (sY < eY) {
					sb.append('R');
					sY++;
				}
				while (sY > eY) {
					sb.append('L');
					sY--;
				}
				sb.append('!');
			}
			return sb.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

