//给定一个矩阵 A， 返回 A 的转置矩阵。 
//
// 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 输入：[[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 1000 
// 1 <= A[0].length <= 1000 
// 
// Related Topics 数组

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：转置矩阵
public class P867TransposeMatrix {

	@Test
	public void testResult() {
		Solution solution = new P867TransposeMatrix().new Solution();
		// TO TEST
		int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] ret = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		Assert.assertArrayEquals(ret, solution.transpose(A));
	}

	@Test
	public void testResult2() {
		Solution solution = new P867TransposeMatrix().new Solution();
		// TO TEST
		int[][] A = {{1, 2, 3}, {4, 5, 6}};
		int[][] ret = {{1, 4}, {2, 5}, {3, 6}};
		Assert.assertArrayEquals(ret, solution.transpose(A));
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[][] transpose(int[][] A) {
			int x = A.length;
			int y = A[0].length;
			int[][] ret = new int[y][x];
			for (int i = 0; i < x; ++i) {
				for (int j = 0; j < y; ++j) {
					ret[j][i] = A[i][j];
				}
			}
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

