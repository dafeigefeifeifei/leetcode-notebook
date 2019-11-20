//给出一个整数数组 A 和一个查询数组 queries。 
//
// 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。 
//
// （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。） 
//
// 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。 
//
// 
//
// 示例： 
//
// 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
//输出：[8,6,2,4]
//解释：
//开始时，数组为 [1,2,3,4]。
//将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
//将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
//将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
//将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// 1 <= queries.length <= 10000 
// -10000 <= queries[i][0] <= 10000 
// 0 <= queries[i][1] < A.length 
// 
// Related Topics 数组

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：查询后的偶数和
public class P985SumOfEvenNumbersAfterQueries {

	@Test
	public void testResult() {
		Solution solution = new P985SumOfEvenNumbersAfterQueries().new Solution();
		// TO TEST
		int[] A = {1, 2, 3, 4};
		int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
		int[] ret = solution.sumEvenAfterQueries(A, queries);
		int[] expect = {8, 6, 2, 4};
		Assert.assertArrayEquals(expect, ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P985SumOfEvenNumbersAfterQueries().new Solution();
		// TO TEST
		int[] A = {5, 5, 4};
		int[][] queries = {{0, 1}, {1, 0}, {4, 1}};
		int[] ret = solution.sumEvenAfterQueries(A, queries);
		int[] expect = {4, 10, 10};
		Assert.assertArrayEquals(expect, ret);
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
			Map<Integer, Integer> map = new HashMap<>();
			int sum = 0;
			for (int i = 0; i < A.length; ++i) {
				if (A[i] % 2 == 0) {
					map.put(i, 1);
					sum += A[i];
				}
			}
			int n = queries.length;
			int[] ans = new int[n];
			for (int i = 0; i < n; ++i) {
				int num = queries[i][0];
				int index = queries[i][1];
				if ((num + A[index]) % 2 == 0) {
					if (map.containsKey(index)) {
						ans[i] = sum + num;
					} else {
						ans[i] = sum + num + A[index];
					}
					sum = ans[i];
					map.put(index, 1);
				} else {
					if (map.containsKey(index)) {
						ans[i] = sum - A[index];
					} else {
						ans[i] = sum;
					}
					sum = ans[i];
					map.remove(index);
				}
				A[index] += num;
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

