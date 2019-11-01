//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串

package leetcode.editor.cn;

import java.util.*;

//Java：反转字符串中的元音字母
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        // TO TEST
        String s = "aA";
        String ret = solution.reverseVowels(s);
        System.out.println(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            Set<String> set = new HashSet<String>() {{
                add("a");
                add("e");
                add("i");
                add("o");
                add("u");
                add("A");
                add("E");
                add("I");
                add("O");
                add("U");
            }};
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < s.length(); ++i) {
                String cur = s.substring(i, i + 1);
                if (set.contains(cur)) {
                    list.add(cur);
                }
            }
            Collections.reverse(list);
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int i = 0; i < s.length(); ++i) {
                String cur = s.substring(i, i + 1);
                if (!set.contains(cur)) {
                    sb.append(s.charAt(i));
                } else {
                    sb.append(list.get(index++));
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}