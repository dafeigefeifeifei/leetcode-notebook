//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 555 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//Java：全排列 II
public class P47PermutationsIi {

	@Test
	public void testResult() {
		Solution solution = new P47PermutationsIi().new Solution();        // TO TEST
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> permuteUnique(int[] nums) {
			List<List<Integer>> ret = new ArrayList<>();
			List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
			getList(numsList, ret, new ArrayList<>());
			return ret.stream().distinct().collect(Collectors.toList());
		}

		private void getList(List<Integer> numsList, List<List<Integer>> ret, List<Integer> curList) {
			if (0 == numsList.size()) {
				ret.add(new ArrayList<>(curList));
				return;
			}
			for (int i = 0; i < numsList.size(); i++) {
				curList.add(numsList.get(i));
				List<Integer> tempList = new ArrayList<>(numsList);
				tempList.remove(i);
				getList(tempList, ret, curList);
				curList.remove(curList.size() - 1);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

