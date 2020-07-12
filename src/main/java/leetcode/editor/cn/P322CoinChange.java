//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：零钱兑换
public class P322CoinChange {

	@Test
	public void testResult() {
		Solution solution = new P322CoinChange().new Solution();        // TO TEST
		int[] coins = {1, 2, 5};
		int amount = 11;
		int ret = solution.coinChange(coins, amount);
		int expect = 3;
		Assert.assertEquals(expect, ret);
	}

	@Test
	public void testResult2() {
		Solution solution = new P322CoinChange().new Solution();        // TO TEST
		int[] coins = {2};
		int amount = 3;
		int ret = solution.coinChange(coins, amount);
		int expect = -1;
		Assert.assertEquals(expect, ret);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int coinChange(int[] coins, int amount) {
			if (amount == 0) {
				return 0;
			}
			int[] dp = new int[amount + 1];
			dp[0] = 0;
			for (int i = 1; i < dp.length; i++) {
				dp[i] = amount + 1;
				for (int coin : coins) {
					if (i - coin < 0) {
						continue;
					}
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
			return dp[amount] == amount + 1 ? -1 : dp[amount];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

