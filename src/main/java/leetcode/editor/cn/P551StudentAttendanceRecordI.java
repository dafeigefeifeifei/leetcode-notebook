//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。 
//
// 示例 1: 
//
// 输入: "PPALLP"
//输出: True
// 
//
// 示例 2: 
//
// 输入: "PPALLL"
//输出: False
// 
// Related Topics 字符串

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：学生出勤记录 I
public class P551StudentAttendanceRecordI {

	@Test
	public void testResult() {
		Solution solution = new P551StudentAttendanceRecordI().new Solution();
		// TO TEST
		boolean result1 = solution.checkRecord("PPALLP");
		Assert.assertEquals(result1, true);
		boolean result2 = solution.checkRecord("PPALLL");
		Assert.assertEquals(result2, false);

	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean checkRecord(String s) {
			int flag1 = 0, flag2 = 0;
			if (s.isEmpty() || s.length() == 0) {
				return true;
			}
			for (int i = 0; i < s.length(); ++i) {
				char c = Character.toUpperCase(s.charAt(i));
				if (c == 'A') {
					flag1++;
				}
				if (c == 'L') {
					flag2++;
				} else {
					flag2 = 0;
				}
				if (flag1 > 1 || flag2 > 2) {
					return false;
				}
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

