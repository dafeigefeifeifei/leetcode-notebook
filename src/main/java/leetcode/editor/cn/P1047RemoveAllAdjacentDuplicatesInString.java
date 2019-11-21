//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//Java：删除字符串中的所有相邻重复项
public class P1047RemoveAllAdjacentDuplicatesInString {

	@Test
	public void testResult() {
		Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
		// TO TEST
		String S = "abbaca";
		String ret = solution.removeDuplicates(S);
		Assert.assertEquals("ca", ret);
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String removeDuplicates(String S) {
			Stack<String> stack = new Stack<>();
			for (int i = 0; i < S.length(); ++i) {
				String subStr = S.substring(i, i + 1);
				if (stack.isEmpty()) {
					stack.add(subStr);
				} else {
					if (stack.peek().equals(subStr)) {
						stack.pop();
					} else {
						stack.add(subStr);
					}
				}
			}
			List<String> strings = new ArrayList<>(stack);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < strings.size(); ++i) {
				sb.append(strings.get(i));
			}
			return sb.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

