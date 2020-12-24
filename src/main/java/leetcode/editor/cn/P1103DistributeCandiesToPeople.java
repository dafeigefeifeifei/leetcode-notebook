//排排坐，分糖果。 
//
// 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。 
//
// 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。 
//
// 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。 
//
// 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发
//出的糖果多），这些糖果也会全部发给当前的小朋友。 
//
// 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
// 
//
// 
//
// 示例 1： 
//
// 输入：candies = 7, num_people = 4
//输出：[1,2,3,1]
//解释：
//第一次，ans[0] += 1，数组变为 [1,0,0,0]。
//第二次，ans[1] += 2，数组变为 [1,2,0,0]。
//第三次，ans[2] += 3，数组变为 [1,2,3,0]。
//第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
// 
//
// 示例 2： 
//
// 输入：candies = 10, num_people = 3
//输出：[5,2,3]
//解释：
//第一次，ans[0] += 1，数组变为 [1,0,0]。
//第二次，ans[1] += 2，数组变为 [1,2,0]。
//第三次，ans[2] += 3，数组变为 [1,2,3]。
//第四次，ans[0] += 4，最终数组变为 [5,2,3]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candies <= 10^9 
// 1 <= num_people <= 1000 
// 
// Related Topics 数学 
// 👍 83 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

//Java：分糖果 II
public class P1103DistributeCandiesToPeople {

	@Test
	public void testResult() {
		Solution solution = new P1103DistributeCandiesToPeople().new Solution();        // TO TEST
		int[] ret = solution.distributeCandies(10, 3);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] distributeCandies(int candies, int num_people) {
			int[] ret = new int[num_people];
			int now = 0; // 已发
			int carry = 1; //递增糖果数
			for (int i = 0; i < num_people; i++) {
				if (candies - now >= carry) {
					ret[i] += carry;
					now += carry;
				} else if (candies > now) {
					ret[i] += candies - now;
					now = candies;
				} else {
					break;
				}
				carry++;
				if (i == num_people - 1) {
					i = -1;
				}
			}
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
