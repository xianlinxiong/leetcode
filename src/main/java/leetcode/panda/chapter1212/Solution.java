package leetcode.panda.chapter1212;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={
                2,1,4,3,9,6};
        System.out.println(s.relativeSortArray(arr1, arr2));

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> aMap = new HashMap<>();
        for(int i : arr1){
            aMap.put(i, aMap.getOrDefault(i, 0)+1);
        }
        int index =0;
        for(int i :arr2){
            int cnt = aMap.get(i);
            aMap.remove(i);
            Arrays.fill(arr1, index, index+cnt, i);
            index += cnt;
        }
        int start = index;
        for(Map.Entry<Integer, Integer> entry : aMap.entrySet()){
            Arrays.fill(arr1, index, index+entry.getValue(), entry.getKey());
            index += entry.getValue();
        }
        Arrays.sort(arr1, start,arr1.length);
        return arr1;
    }
}