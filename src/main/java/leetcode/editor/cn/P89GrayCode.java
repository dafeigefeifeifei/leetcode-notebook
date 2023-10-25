//n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
//
// 
// 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1） 
// 第一个整数是 0 
// 一个整数在序列中出现 不超过一次 
// 每对 相邻 整数的二进制表示 恰好一位不同 ，且 
// 第一个 和 最后一个 整数的二进制表示 恰好一位不同 
// 
//
// 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,3,2]
//解释：
//[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
//- 00 和 01 有一位不同
//- 01 和 11 有一位不同
//- 11 和 10 有一位不同
//- 10 和 00 有一位不同
//[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
//- 00 和 10 有一位不同
//- 10 和 11 有一位不同
//- 11 和 01 有一位不同
//- 01 和 00 有一位不同
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 
//
// Related Topics 位运算 数学 回溯 👍 650 👎 0


package leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.*;

//Java：格雷编码
public class P89GrayCode {

    @Test
    public void testResult() {
        Solution solution = new P89GrayCode().new Solution();        // TO TEST
        List<Integer> ret = solution.grayCode(2);
        for (Integer i : ret) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 由于最高位前默认为 0，因此 G′(n) = G(n)，只需在 res(即 G(n)) 后添加 R′(n) 即可；
     * 计算 R′(n)：执行 head = 1 << i 计算出对应位数，以给 R(n) 前添加 1 得到对应 R′(n)；
     * 倒序遍历 res(即 G(n))：依次求得 R′(n) 各元素添加至 res 尾端，遍历完成后 res(即 G(n+1))。
     *
     */
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            int head = 1;
            for (int i = 0; i < n; i++) {
                for (int j = ret.size() - 1; j >= 0; j--) {
                    ret.add(head + ret.get(j));
                }
                head <<= 1;
            }
            return ret;
        }
    }
    /**
     *
     解题思路：
     设 n 阶格雷码集合为 G(n)，则 G(n+1) 阶格雷码可以通过以下三步得到：

     给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 G′(n)；
     设 G(n) 集合倒序（镜像）为 R(n)，给 R(n) 每个元素二进制形式前面添加 1，得到 R′(n)；
     G(n+1) = G′(n) ∪ R′(n) 拼接两个集合即可得到下一阶格雷码。
     根据以上规律，我们可从 0 阶格雷码推导致任何阶格雷码。

     当 n = 1 时：

     G(0) = [0]
     G′(0) = [0]
     R(0) = [0]
     R′(0) = [1]
     G(1) = G′(0) ∪ R′(0) = [0, 1]
     当 n = 2 时：

     G(1) = [0, 1]
     G′(1) = [00, 01]
     R(1) = [1, 0]
     R′(1) = [11, 10]
     G(2) = G′(1) ∪ R′(1) = [00, 01, 11, 10] = [0, 1, 3, 2]
     当 n = 3 时：

     G(2) = [0, 1, 3, 2]
     G′(2) = [000, 001, 011, 010]
     R(2) = [2, 3, 1, 0]
     R′(2) = [110, 111, 101, 100]
     G(3) = G′(2) ∪ R′(2) = [000, 001, 011, 010, 110, 111, 101, 100] = [0, 1, 3, 2, 6, 7, 5, 4]

     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}

