//给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。 
//
// 示例 1: 
//
// 
//输入:"-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入:"-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入:"1/3-1/2"
//输出: "-1/6"
// 
//
// 示例 4: 
//
// 
//输入:"5/3+1/3"
//输出: "2/1"
// 
//
// 说明: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// Related Topics 数学

package leetcode.editor.cn;

import java.util.*;

//Java：分数加减运算
public class P592FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        Solution solution = new P592FractionAdditionAndSubtraction().new Solution();
        // TO TEST
        String exp1 = "-1/2+1/2";
        String ret = solution.fractionAddition(exp1);
        System.out.println(ret);
        // TO TEST
        String exp2 = "-1/2+1/2+1/3";
        String ret2 = solution.fractionAddition(exp2);
        System.out.println(ret2);
        // TO TEST
        String exp3 = "5/3+1/3";
        String ret3 = solution.fractionAddition(exp3);
        System.out.println(ret3);
        System.out.println(ret2);
        // TO TEST
        String exp4 = "1/3-1/2";
        String ret4 = solution.fractionAddition(exp4);
        System.out.println(ret4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String expression) {
            List<String> strs = new ArrayList<String>();
            int first = 0;
            for (int i = 0; i < expression.length(); ++i) {
                char c = expression.charAt(i);
                if ((c == '+' || c == '-') && i != 0) {
                    strs.add(expression.substring(first, i));
                    first = i;
                }
            }
            strs.add(expression.substring(first));
            String carry = strs.get(0);
            for (int i = 1; i < strs.size(); i++) {
                carry = calcu(carry, strs.get(i));
            }
            return carry;
        }

        private String calcu(String str1, String str2) {
            int up1 = Integer.parseInt(str1.substring(0, str1.indexOf("/")));
            int down1 = Integer.parseInt(str1.substring(str1.indexOf("/") + 1));
            int up2 = Integer.parseInt(str2.substring(0, str2.indexOf("/")));
            int down2 = Integer.parseInt(str2.substring(str2.indexOf("/") + 1));
            int down = down1 * down2;
            int up = up1 * down2 + up2 * down1;
            int gcd = Math.abs(gcd(up, down));
            return up / gcd + "/" + down / gcd;
        }

        private int gcd(int up, int down) {
            if (down == 0) {
                return up;
            }
            return gcd(down, up % down);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}