package leetcode.panda.chapter0062;

/**
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        long begin = System.currentTimeMillis();
        System.out.println(s.uniquePaths(51,9));
        long middle = System.currentTimeMillis();
        System.out.println(s.goHalf(51, 9));
        long end = System.currentTimeMillis();

        System.out.println(middle-begin);
        System.out.println(end-middle);
    }

    /**
     * 递归计算
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return doCount(1, 1, m, n, 0);
    }

    int doCount(int left, int top, int m, int n, int count){
        if(left == m || top == n){
            return count + 1;
        }
        count = doCount(left+1, top, m, n, count);
        count = doCount(left, top+1, m, n, count);

        return count;
    }

    /**
     * 折半优化：从中间截断部分
     * @param m
     * @param n
     * @return
     */
    int goHalf(int m, int n){
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        m = max;
        n = min;
        int half = m /2;
        if(half <=1 ){
            return doCount(1,1,m,n,0);
        }
        int count = 0;
        for(int i =1; i<= n; i++){
            count += doCount(1, 1, half, i, 0) * doCount(half+1, i, m, n, 0);
        }
        return count;
    }

    /**
     * 动态规划： a[i][j] = a[i-1][j]=a[i][j-1]
     * @param m
     * @param n
     * @return
     */
    int dynamic(int m, int n){
        int[][] array = new int[m][n];
        for(int i =0; i< m; i++){
            array[i][0] =1;
        }
        for(int j =0; j<n; j++){
            array[0][j] =1;
        }
        for(int i =1; i<m; i++){
            for(int j =1; j<n; j++){
                array[i][j]=array[i-1][j]+array[i][j-1];
            }
        }

        return array[m-1][n-1];
    }

}