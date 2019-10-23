//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。 
//请注意，它是排序后的第k小元素，而不是第k个元素。 
//
// 示例: 
//
// 
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 说明: 
//你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找

package leetcode.editor.cn;

//Java：有序矩阵中第K小的元素
public class P378KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int row = matrix.length, column = matrix[0].length;
            int left = matrix[0][0], right = matrix[row - 1][column - 1];
            while (left <= right) {
                int count = 0;
                int mid = left + (right - left) / 2;
                for (int i = 0; i < row; ++i) {
                    for (int j = 0; j < column && matrix[i][j] <= mid; ++j) {
                        ++count;
                    }
                }
                if (count < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}