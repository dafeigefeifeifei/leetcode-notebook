//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 345 👎 0


package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

//Java：二进制矩阵中的最短路径
public class P1091ShortestPathInBinaryMatrix {

    @Test
    public void testResult() {
        Solution solution = new P1091ShortestPathInBinaryMatrix().new Solution();        // TO TEST
        int[][] grid = {{0,1}, {1,0}};
        int actual = solution.shortestPathBinaryMatrix(grid);
        int expect = 2;
        Assert.assertEquals(expect,actual);
    }


    @Test
    public void testResult1() {
        Solution solution = new P1091ShortestPathInBinaryMatrix().new Solution();        // TO TEST
        int[][] grid = {{0,0,0}, {1,1,0},{1,1,0}};
        int actual = solution.shortestPathBinaryMatrix(grid);
        int expect = 4;
        Assert.assertEquals(expect,actual);
    }


    @Test
    public void testResult2() {
        Solution solution = new P1091ShortestPathInBinaryMatrix().new Solution();        // TO TEST
        int[][] grid = {{1,0,0}, {1,1,0}, {1,1,0}};
        int actual = solution.shortestPathBinaryMatrix(grid);
        int expect = -1;
        Assert.assertEquals(expect,actual);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (n < 1) {
                return -1;
            }
            if(grid[0][0] != 0){
                return -1;
            }
            Map<String, Integer> distMap = new HashMap<>();
            int i = 0, j = 0;
            LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
            Map<String, Boolean> visitMap = new HashMap<>();
            String key = i + "_" + j;
            queue.add(key);
            distMap.put(key, 1);
            visitMap.put(key, true);
            while (!queue.isEmpty()) {
                String k = queue.poll();
                String[] split = k.split("_");
                i = Integer.valueOf(split[0], 10);
                j = Integer.valueOf(split[1], 10);
                if(isFinish(n, i, j)){
                    if(grid[i][j] == 0) {
                        return distMap.get(i + "_" + j);
                    }else{
                        return -1;
                    }
                }
                for (int u = -1; u < 2; u++) {
                    for (int v = -1; v < 2; v++) {
                        int x = i + u;
                        int y = j + v;

                        String newKey = x + "_" + y;
                        if(isInSize(n ,x, y) && grid[x][y] == 0 && !visitMap.containsKey(newKey)){
                            queue.add(newKey);
                            visitMap.put(newKey, true);
                            distMap.put(newKey, distMap.get(i + "_" + j) + 1);
                        }
                    }
                }
            }
            return -1;
        }

        private Boolean isInSize(int n, int i, int j) {
            return i >= 0 && i < n && j >= 0 && j < n;
        }

        private Boolean isFinish(int n, int i, int j) {
            return i == n-1 && j == n-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

