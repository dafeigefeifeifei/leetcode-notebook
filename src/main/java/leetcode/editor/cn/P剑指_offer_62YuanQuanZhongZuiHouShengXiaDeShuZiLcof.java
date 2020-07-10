//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
//


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：圆圈中最后剩下的数字
public class P剑指_offer_62YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

	@Test
	public void testResult() {
		Solution solution = new P剑指_offer_62YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();        // TO TEST
		int ret = solution.lastRemaining(5, 3);
		int expect = 3;
		Assert.assertEquals(expect,ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P剑指_offer_62YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();        // TO TEST
		int ret = solution.lastRemaining(10, 17);
		int expect = 2;
		Assert.assertEquals(expect,ret);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lastRemaining(int n, int m) {
			int[] a = new int[n];
			int count = 0, i = 0, j = 0;
			while (count < n - 1) {
				if (j == m - 1 && a[i] == 0) {
					a[i] = 1;
					++count;
					i = Next(i, n);
					j = 0;
				} else if (a[i] == 0) {
					i = Next(i, n);
					++j;
				} else {
					i = Next(i, n);
				}
			}
			int ret = -1;
			for (int k = 0; k < n; k++) {
				if(a[k] == 0){
					ret = k;
				}
			}
			return ret;
		}

		private int Next(int i, int n) {
			int ret = i + 1;
			if (ret == n) {
				ret = 0;
			}
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

