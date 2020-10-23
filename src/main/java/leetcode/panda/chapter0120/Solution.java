package leetcode.panda.chapter0120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,3));
        System.out.println(s.minimumTotal(lists));

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> result = new ArrayList<>();

        result.add(triangle.get(0).get(0));

        int length = triangle.size();
        for(int i =1; i < length; i++){
            List<Integer> cur = triangle.get(i);
            result.add(result.get(result.size()-1)+cur.get(cur.size()-1));
            int current = cur.size()-2;
            while(current -1 >= 0){
                result.set(current, cur.get(current) + Math.min(result.get(current), result.get(current-1)));
                current--;
            }

            result.set(0, result.get(0)+cur.get(0));
        }
        int min = Integer.MAX_VALUE;
        for(int i : result){
            min = Math.min(min, i);
        }
        return min;

//        return getTotal(triangle,0,0);

    }

    /**
     * 递归暴力破解法则
     * getTotal(triangle, 0, 0)
     * @param triangle
     * @param height
     * @param cur
     * @return
     */
    private int getTotal(List<List<Integer>> triangle, int height, int cur){
        int current = triangle.get(height).get(cur);
        if(height == triangle.size() - 1){
            return current;
        }

        int left = getTotal(triangle, height+1, cur);
        int right = getTotal(triangle,height+1, cur+1);
        return current + Math.min(left, right);
    }
}