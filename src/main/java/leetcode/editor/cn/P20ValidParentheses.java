//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.*;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        String s = "()[]{}";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<String>();
            Map<String, String> map = new HashMap<String, String>() {{
                put(")", "(");
                put("]", "[");
                put("}", "{");
            }};
            Set<String> inSet = new HashSet<String>() {{
                add("(");
                add("[");
                add("{");
            }};
            for (int i = 0; i < s.length(); ++i) {
                String cur = s.substring(i, i + 1);
                if (inSet.contains(cur)) {
                    stack.push(cur);
                } else if (map.containsKey(cur) && !stack.isEmpty() && map.get(cur).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (!stack.isEmpty()) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}