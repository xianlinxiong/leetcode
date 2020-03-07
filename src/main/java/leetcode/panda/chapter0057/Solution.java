package leetcode.panda.chapter0057;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1,3},{6,9}};
        Solution s = new Solution();
        int[] key = {2,5};
        System.out.println(s.insert(nums,key).length);

    }

    /**
     * 设定skipLeft， skipRight；
     * skipLeft定义：nerInterval的首元素在skipLeft位置元素之后；
     * skipRight定义：newInterval的尾元素在skipRight位置元素之前；
     * 然后将skipLeft+1 、skipRight-1、 以及newInterval做合并。
     * 注意skipLeft、和skipRight边界值问题
     *
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int skipLeft = -1;
        int length = intervals.length;
        for(int i = 0; i< length && intervals[i][1] < newInterval[0]; i++){
            skipLeft = i;
        }
        int skipRight = length;
        for(int i = length-1; i > skipLeft && intervals[i][0] > newInterval[1]; i--){
            skipRight = i;
        }
        int newLength = skipLeft + 1 + length-skipRight + 1;

        int[][] result = new int[newLength][2];
        int i = 0;
        for(;i <= skipLeft; i++){
            result[i] = intervals[i];
        }
        if(skipLeft == length-1){
            result[i][0] = newInterval[0];
        }
        else{
            result[i][0] = Math.min(newInterval[0] , intervals[skipLeft+1][0]);
        }
        if(skipRight == 0){
            result[i][1] = newInterval[1];
        }
        else{
            result[i][1] = Math.max(newInterval[1], intervals[skipRight-1][1]);
        }
        i++;
        for(;i<newLength; i++){
            result[i] = intervals[skipRight];
            skipRight++;
        }

        return result;

    }
}
