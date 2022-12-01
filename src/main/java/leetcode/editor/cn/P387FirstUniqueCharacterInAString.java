//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 624 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：字符串中的第一个唯一字符
public class P387FirstUniqueCharacterInAString {

    @Test
    public void testResult() {
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();        // TO TEST
        String s = "leetcode";
        int actual = solution.firstUniqChar(s);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();        // TO TEST
        String s = "loveleetcode";
        int actual = solution.firstUniqChar(s);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testResult2() {
        Solution solution = new P387FirstUniqueCharacterInAString().new Solution();        // TO TEST
        String s = "aabb";
        int actual = solution.firstUniqChar(s);
        Assert.assertEquals(-1, actual);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c) && map.get(c) != -1) {
                    map.put(c, -1);
                } else if (!map.containsKey(c)) {
                    map.put(c, i);
                }
            }
            Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Character, Integer> entry = it.next();
                if (entry.getValue() != -1) {
                    return entry.getValue();
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

