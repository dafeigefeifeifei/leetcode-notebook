//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
//
// Related Topics 字符串 👍 646 👎 0


package leetcode.editor.cn;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;
//Java：最后一个单词的长度
public class P58LengthOfLastWord{
    
    @Test
    public void testResult() {
        Solution solution = new P58LengthOfLastWord().new Solution();        // TO TEST
        String s = "Hello World";
        int actual = solution.lengthOfLastWord(s);
        Assert.assertEquals(5, actual);
    }

    @Test
    public void testResult1() {
        Solution solution = new P58LengthOfLastWord().new Solution();        // TO TEST
        String s = " fly me to the moon ";
        int actual = solution.lengthOfLastWord(s);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testResult2() {
        Solution solution = new P58LengthOfLastWord().new Solution();        // TO TEST
        String s = "luffy is still joyboy";
        int actual = solution.lengthOfLastWord(s);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void testResult3() {
        Solution solution = new P58LengthOfLastWord().new Solution();        // TO TEST
        String s = "a";
        int actual = solution.lengthOfLastWord(s);
        Assert.assertEquals(1, actual);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        if(null == s || s.trim().equals("")){
            return 0;
        }
        s = s.trim();
        int n = s.length();
        for (int i = n - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if(c == ' '){
                return n - 1 - i;
            }
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

