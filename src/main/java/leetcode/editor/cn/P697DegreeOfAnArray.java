//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 示例 1: 
//
// 
//输入: [1, 2, 2, 3, 1]
//输出: 2
//解释: 
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2: 
//
// 
//输入: [1,2,2,3,1,4,2]
//输出: 6
// 
//
// 注意: 
//
// 
// nums.length 在1到50,000区间范围内。 
// nums[i] 是一个在0到49,999范围内的整数。 
// 
// Related Topics 数组 
// 👍 197 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：数组的度
public class P697DegreeOfAnArray {

	@Test
	public void testResult() {
		Solution solution = new P697DegreeOfAnArray().new Solution();
		// TO TEST
		int[] nums = {1, 2, 2, 3, 1, 4, 2};
		int actual = solution.findShortestSubArray(nums);
		Assert.assertEquals(6, actual);
	}

	@Test
	public void testResult2() {
		Solution solution = new P697DegreeOfAnArray().new Solution();
		// TO TEST
		int[] nums = {1, 2, 2, 3, 1};
		int actual = solution.findShortestSubArray(nums);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void testResult3() {
		Solution solution = new P697DegreeOfAnArray().new Solution();
		// TO TEST
		int[] nums = {};
		int actual = solution.findShortestSubArray(nums);
		Assert.assertEquals(0, actual);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int findShortestSubArray(int[] nums) {
			if (null == nums || nums.length == 0) {
				return 0;
			}
			Map<Integer, Detail> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int now = nums[i];
				Detail detail;
				if (map.containsKey(now)) {
					detail = map.get(now);
					detail.setCnt(detail.getCnt() + 1);
					detail.setEnd(i);
					detail.setLength(i - detail.getStart() + 1);
				} else {
					detail = new Detail(1, i, i, 1);
				}
				map.put(now, detail);
			}
			int max = Integer.MIN_VALUE;
			List<Integer> resultList = new ArrayList<>();
			for (Integer key : map.keySet()) {
				Detail detail = map.get(key);
				if (detail.getCnt() > max) {
					resultList.clear();
					max = detail.getCnt();
					resultList.add(key);
				} else if (detail.getCnt() == max) {
					resultList.add(key);
				}
			}
			int min = Integer.MAX_VALUE;
			for (Integer ret : resultList) {
				int length = map.get(ret).getLength();
				if (length < min) {
					min = length;
				}
			}
			return min;
		}

		public class Detail {
			private int cnt;
			private int start;
			private int end; // 双闭
			private int length;

			public Detail() {
			}

			public Detail(int cnt, int start, int end, int length) {
				this.cnt = cnt;
				this.start = start;
				this.end = end;
				this.length = length;
			}

			public int getCnt() {
				return cnt;
			}

			public void setCnt(int cnt) {
				this.cnt = cnt;
			}

			public int getStart() {
				return start;
			}

			public void setStart(int start) {
				this.start = start;
			}

			public int getEnd() {
				return end;
			}

			public void setEnd(int end) {
				this.end = end;
			}

			public int getLength() {
				return length;
			}

			public void setLength(int length) {
				this.length = length;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

