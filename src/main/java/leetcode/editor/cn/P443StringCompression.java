//给定一组字符，使用原地算法将其压缩。 
//
// 压缩后的长度必须始终小于或等于原数组长度。 
//
// 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。 
//
// 在完成原地修改输入数组后，返回数组的新长度。 
//
// 
//
// 进阶： 
//你能否仅使用O(1) 空间解决问题？ 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["a","a","b","b","c","c","c"]
//
//输出：
//返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
//
//说明：
//"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
// 
//
// 示例 2： 
//
// 
//输入：
//["a"]
//
//输出：
//返回1，输入数组的前1个字符应该是：["a"]
//
//说明：
//没有任何字符串被替代。
// 
//
// 示例 3： 
//
// 
//输入：
//["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//
//输出：
//返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
//
//说明：
//由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
//注意每个数字在数组中都有它自己的位置。
// 
//
// 注意： 
//
// 
// 所有字符都有一个ASCII值在[35, 126]区间内。 
// 1 <= len(chars) <= 1000。 
// 
// Related Topics 字符串

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：压缩字符串
// 逻辑没问题，题目傻逼
public class P443StringCompression {

	@Test
	public void testResult() {
		Solution solution = new P443StringCompression().new Solution();
		// TO TEST
		char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		int ret1 = solution.compress(chars1);
		Assert.assertEquals(6, ret1);
	}

	@Test
	public void testResult2() {
		Solution solution = new P443StringCompression().new Solution();
		// TO TEST
		char[] chars2 = {'a'};
		int ret2 = solution.compress(chars2);
		Assert.assertEquals(1, ret2);
	}

	@Test
	public void testResult3() {
		Solution solution = new P443StringCompression().new Solution();
		// TO TEST
		char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b'};
		int ret3 = solution.compress(chars3);
		Assert.assertEquals(3, ret3);
	}

	@Test
	public void testResult4() {
		Solution solution = new P443StringCompression().new Solution();
		// TO TEST
		char[] chars3 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		int ret3 = solution.compress(chars3);
		Assert.assertEquals(6, ret3);
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int compress(char[] chars) {
			if (chars.length < 2) {
				return chars.length;
			}
			int count = 0;
			char pre = '#';
			List<Character> list = new ArrayList<>();
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				if (pre == c) {
					++count;
				} else if (pre != c) {
					trans(list, count);
					list.add(c);
					pre = c;
					count = 1;
				}
				if (pre == c && i == chars.length - 1) {
					trans(list, count);
				}
			}
			return list.size();
		}

		private void trans(List<Character> list, int count) {
			Stack<Integer> s = new Stack<>();
			while (count > 0) {
				int a = count % 10;
				s.add(a);
				count /= 10;
			}
			while (!s.isEmpty()) {
				int top = s.peek();
				if (top > 1) list.add(Integer.toString(top).charAt(0));
				s.pop();
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

