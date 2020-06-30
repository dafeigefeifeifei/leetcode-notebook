//给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。 
//
// 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。 
//
// 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-3,2,-3,4,2]
//输出：5
//解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
//                累加求和
//                startValue = 4 | startValue = 5 | nums
//                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2]
//输出：1
//解释：最小的 startValue 需要是正数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-2,-3]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
// Related Topics 数组


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：逐步求和得到正数的最小值
public class P1413MinimumValueToGetPositiveStepByStepSum {

	@Test
	public void testResult() {
		Solution solution = new P1413MinimumValueToGetPositiveStepByStepSum().new Solution();
		// TO TEST
		int[] nums = {1, -2, -3};
		int expect = 5;
		int ret = solution.minStartValue(nums);
		Assert.assertEquals(ret, expect);
	}

	@Test
	public void testResult2() {
		Solution solution = new P1413MinimumValueToGetPositiveStepByStepSum().new Solution();
		// TO TEST
		int[] nums = {-3, 2, -3, 4, 2};
		int expect = 5;
		int ret = solution.minStartValue(nums);
		Assert.assertEquals(ret, expect);
	}

	@Test
	public void testResult3() {
		Solution solution = new P1413MinimumValueToGetPositiveStepByStepSum().new Solution();
		// TO TEST
		int[] nums = {1, 2};
		int expect = 1;
		int ret = solution.minStartValue(nums);
		Assert.assertEquals(ret, expect);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minStartValue(int[] nums) {
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int i = 0; i < nums.length; ++i) {
				sum += nums[i];
				if (sum < min) {
					min = sum;
				}
			}
			int ret = 1 - min;

			return ret > 0 ? ret : 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

