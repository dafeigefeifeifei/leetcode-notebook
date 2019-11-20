//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//Java：全排列
public class P46Permutations {

	@Test
	public void testResult() {
		Solution solution = new P46Permutations().new Solution();
		// TO TEST
		int[] nums = {1, 2, 3};
		List<List<Integer>> ret = solution.permute(nums);
		for (int i = 0; i < ret.size(); ++i) {
			for (int j = 0; j < ret.get(i).size(); ++j) {
				System.out.print(ret.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
			List<List<Integer>> ret = new ArrayList<>();
			getAll(ret, new ArrayList<>(), numList);
			return ret;
		}

		private void getAll(List<List<Integer>> ret, List<Integer> curList, List<Integer> numList) {
			if (numList.size() == 0) {
				ret.add(new ArrayList<>(curList));
				return;
			}
			for (int i = 0; i < numList.size(); ++i) {
				curList.add(numList.get(i));
				List<Integer> tempList = new ArrayList<>(numList);
				tempList.remove(tempList.get(i));
				getAll(ret, curList, tempList);
				curList.remove(curList.size() - 1);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

