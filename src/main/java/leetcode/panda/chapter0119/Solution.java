package leetcode.panda.chapter0119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getRow(3));
    }
    public List<Integer> getRow(int numRows) {
        if(0 == numRows){
            return Collections.emptyList();
        }
        List<Integer> last = new ArrayList<>();
        last.add(1);
        for(int i = 1; i <= numRows; i++){
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for(int j = 1; j < last.size(); j++){
                next.add(last.get(j)+ last.get(j-1));
            }
            next.add(1);
            last= next;
        }
        return last;
    }
}