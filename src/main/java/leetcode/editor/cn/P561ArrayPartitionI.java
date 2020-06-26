//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 
//的 min(ai, bi) 总和最大。 
//
// 示例 1: 
//
// 
//输入: [1,4,3,2]
//
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
// 
//
// 提示: 
//
// 
// n 是正整数,范围在 [1, 10000]. 
// 数组中的元素范围在 [-10000, 10000]. 
// 
// Related Topics 数组


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：数组拆分 I
public class P561ArrayPartitionI {

	@Test
	public void testResult() {
		Solution solution = new P561ArrayPartitionI().new Solution();
		// TO TEST
		int[] nums = {1, 4, 3, 2};
		int respect = 4;
		int ret = solution.arrayPairSum(nums);
		Assert.assertEquals(respect, ret);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int arrayPairSum(int[] nums) {
			Arrays.sort(nums);
			int ret = 0;
			for (int i = 0; i < nums.length; ++i) {
				if (i % 2 == 0) {
					ret += nums[i];
				}
			}
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

