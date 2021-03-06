package leetcode.panda.chapter5638;

import java.util.Arrays;
import java.util.List;

/**
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * <p>
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * <p>
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 * <p>
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * <p>
 * <p>
 * 提示：
 * <p>
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {9,10,1,7,0,2,1,4,1,7,0,11,0,11,0,0,9,11,11,2,0,5,5};

        int[] arr2 = {3,19,1,14,0,4,1,8,2,7,0,13,0,13,0,0,2,2,13,1,0,3,7};
        //        System.out.println(s.minOperations(arr2, 894887480));
        System.out.println(s.eatenApples(arr1, arr2));

    }

    public int eatenApples(int[] apples, int[] days) {
        int left = 0;
        int total = 0;
        int max = 0;
        for (int i = 0; i < apples.length; i++) {
            max = Math.max(max, days[i]+i);
            if(apples[i] < days[i]){
                left = Math.min(left + apples[i], days[i]);
            }else{
                left = Math.max(left, Math.min(apples[i], days[i]));
            }
            if (left > 0) {
                left--;
                total++;
            }
        }


        return total + left;


    }
}