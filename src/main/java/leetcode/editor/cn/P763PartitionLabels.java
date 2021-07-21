//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 
// 👍 531 👎 0


package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

//Java：划分字母区间
public class P763PartitionLabels {

	@Test
	public void testResult() {
		Solution solution = new P763PartitionLabels().new Solution();
		// TO TEST
		List<Integer> ret = solution.partitionLabels("ababcbacadefegdehijhklij");
		ret.forEach(System.out::println);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<Integer> partitionLabels(String s) {
			List<Integer> ret = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				String c = s.charAt(i) + "";
				if (!map.containsKey(c)) {
					map.put(c, i);
				} else {
					map.put(c, Math.max(map.get(c), i));
				}
			}
			int target = 0;
			int num = 0;
			for (int i = 0; i < s.length(); i++) {
				String c = s.charAt(i) + "";
				target = Math.max(target, map.get(c));
				++num;
				if (target == i) {
					ret.add(num);
					num = 0;
				}
			}
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

