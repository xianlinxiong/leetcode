package leetcode.panda.chapter0042;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class Solution {
    public static void main(String[] args) {
//        int[] candidate = {2, 0, 2};
//        int[] candidate = {5, 2,1, 2,1,5};
//        int[] candidate = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] candidate = {5,4,1,2};
//        int[] candidate = {2,1,0,2};
        int[][] test ={{4,2,3},
                {2, 0, 2},
        {5, 2,1, 2,1,5},
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {5,4,1,2},
                {2,1,0,2}
        };
        trap(test[3]);
        for(int[] a : test) {
            System.out.println(trap(a));
        }
    }

    /**
     * 第一步计算高度数组中的此后最大高度数组
     * 用start开始从0遍历：
     *      当height[start]<height[start+1];start往后偏移
     * end=start+1开始遍历：
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int result = 0;
        int length = height.length - 1;
        int start = 0;
        int currentExcept = 0;
        int[] maxes = maxHeight(height);
        while (true) {
            /**
             * 重新定位start位置
             */
           while (start < length - 1 && height[start] <= height[start + 1]) {
                start++;
            }
            boolean up = false;
            int end = start+1;
            while (end <= length) {
                if(height[end-1] <= height[end]){
                    up = true;
                }
                /**
                 * 出口定义height[start] <= height[end]  或者当前值为后续最大值
                 */
                if(height[start] <= height[end] || (height[end] == maxes[end] && height[start] >= maxes[end])){
                    break;
                }
                currentExcept += height[end];
                end++;
            }
            if (up) {
                /**
                 * 修正最后一个值
                 */
                if(end > length){
                    end = length;
                    currentExcept -= height[end];
                }
                result += countPart(start, height[start], end, height[end], currentExcept);
                start = end -1;
            }
            else {
                start = end;
            }
            currentExcept =0;
            if (end >= length - 1) {
                break;
            }
        }


        return result;
    }

    /**
     * 局部容量计算器器
     * @param start
     * @param startHeight
     * @param end
     * @param endHeight
     * @param except
     * @return
     */
    private static int countPart(int start, int startHeight, int end, int endHeight, int except) {
        int width = end - start - 1;
        int height = Math.min(startHeight, endHeight);
        return width * height - except;
    }

    /**
     * 根据输入height计算从当前位置到最后位置的最大高度数组
     * @param height
     * @return
     */
    private static int[] maxHeight(int[] height){
        int length = height.length;
        int[] maxes = new int[length];
        int max = height[length -1];
        for(int i = length-1; i>=0; i--){
            if(max < height[i]){
                max = height[i];
            }
            maxes[i] = max;
        }

        return maxes;
    }


}
