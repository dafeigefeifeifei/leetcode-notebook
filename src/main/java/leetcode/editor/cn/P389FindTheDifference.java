//给定两个字符串 s 和 t ，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 
//输入：s = "", t = "y"
//输出："y"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 367 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Java：找不同
public class P389FindTheDifference {

    @Test
    public void testResult() {
        Solution solution = new P389FindTheDifference().new Solution();        // TO TEST
        String s = "";
        String t = "y";
        char actual = solution.findTheDifference(s, t);
        char expected = 'y';
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P389FindTheDifference().new Solution();        // TO TEST
        String s = "abcd";
        String t = "abcde";
        char actual = solution.findTheDifference(s, t);
        char expected = 'e';
        Assert.assertEquals(expected, actual);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (int k = 0; k < t.length() - 1; k++) {
                char y = t.charAt(k);
                char x = s.charAt(k);
                map.put(y, map.getOrDefault(y, 0) + 1);
                map.put(x, map.getOrDefault(x, 0) - 1);
                if(map.containsKey(x) && map.get(x) == 0){
                    map.remove(x);
                }
                if(map.containsKey(y) && map.get(y) == 0){
                    map.remove(y);
                }
            }
            char z = t.charAt(t.length() - 1);
            map.put(z, map.getOrDefault(z, 0) + 1);
            if(map.containsKey(z) && map.get(z) == 0){
                map.remove(z);
            }
            return map.keySet().stream().findFirst().get();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

