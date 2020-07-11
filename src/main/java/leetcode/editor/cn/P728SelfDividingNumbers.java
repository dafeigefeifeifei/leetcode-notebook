//自除数 是指可以被它包含的每一位数除尽的数。 
//
// 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。 
//
// 还有，自除数不允许包含 0 。 
//
// 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。 
//
// 示例 1： 
//
// 
//输入： 
//上边界left = 1, 下边界right = 22
//输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
// 
//
// 注意： 
//
// 
// 每个输入参数的边界满足 1 <= left <= right <= 10000。 
// 
// Related Topics 数学


package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;


//Java：自除数
public class P728SelfDividingNumbers {

	@Test
	public void testResult() {
		Solution solution = new P728SelfDividingNumbers().new Solution();        // TO TEST
		List<Integer> ret = solution.selfDividingNumbers(1, 22);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<Integer> selfDividingNumbers(int left, int right) {
			List<Integer> result = new ArrayList<>();
			for (int now = left; now <= right; ++now) {
				if (now < 10) {
					result.add(now);
				} else {
					Set<Integer> set = getAllNums(now);
					if (judgeCanDivide(set, now)) {
						result.add(now);
					}
				}
			}
			return result;
		}

		private Set<Integer> getAllNums(int num) {
			if (num == 0) {
				return new HashSet<Integer>() {{
					add(0);
				}};
			}
			Map<Integer, Integer> map = new HashMap<>();
			while (num != 0) {
				int a = num % 10;
				num /= 10;
				if (!map.containsKey(a)) {
					map.put(a, 1);
				}
			}
			return map.keySet();
		}

		private boolean judgeCanDivide(Set<Integer> set, int num) {
			for (Integer i : set) {
				if (i == 0 || num % i != 0) {
					return false;
				}
			}
			return true;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}

