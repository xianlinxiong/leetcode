package leetcode.panda.chapter0015;

import java.util.*;

/**
 * 进阶：水平扫描，垂直扫描，分段查询，最短字符串二分扫描
 */
public class Solution {
    public static void main(String[] args) {

        String[] ss = {"dog", "racecar", "car"};
        int[] ii ={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum2(ii));
    }

    /**
     * 先排序，然后定点，两头移动
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums){
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< length -2; i++){
            for(int j = i + 1, k= length-1;j<k;){
                if(nums[i] + nums[j] + nums[k] == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                else {
                    k--;
                }
                while(j < k && j >i+1 && nums[j] == nums[j-1]){
                    j++;
                }
                while(j<k && k<length-1 && nums[k] == nums[k+1]) {
                    k--;
                }
            }
            while(i < length -2 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }

    /**
     * 想太多，
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return Collections.emptyList();
        }
        int zeroStart = -1, positive = 0;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            if (zeroStart == -1 && temp == 0) {
                zeroStart = i;
            } else if (temp > 0) {
                positive = i;
                break;
            }
        }
        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < positive; i++) {
            int tempI = nums[i];
            for (int j = positive; j < length && tempI+ nums[j] < 0; j++) {
                int tempJ = nums[j];
                for (int k = j + 1; k < length; k++) {
                    int tempK = nums[k];
                    if (tempI + tempJ + tempK == 0) {
                        String s = tempI + "" + tempJ;
                        if (!set.contains(s)) {
                            set.add(s);
                            result.add(Arrays.asList(tempI, tempJ, tempK));
                        }
                    }
                    else if(tempI + tempJ + tempK >0 ){
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < positive; i++) {
            int tempI = nums[i];
            for (int j = i+1; j < positive && nums[j]<0; j++) {
                int tempJ = nums[j];
                for (int k = positive; k < length; k++) {
                    int tempK = nums[k];
                    if (tempI + tempJ + tempK == 0) {
                        String s = tempI + "" + tempJ;
                        if (!set.contains(s)) {
                            result.add(Arrays.asList(tempI, tempJ, tempK));
                            set.add(s);
                        }
                    }
                    else if(tempI + tempJ + tempK > 0){
                        break;
                    }
                }
            }
        }
        if(zeroStart != -1){
            if(zeroStart+2 <  length && nums[zeroStart] + nums[zeroStart+1] + nums[zeroStart+2] == 0){
                result.add(Arrays.asList(0,0,0));
            }
            for(int i =zeroStart-1, j = zeroStart+1; i >=0 && j<length; ){
                int tempI = nums[i];
                int tempJ = nums[j];
                if(tempI+ tempJ > 0){
                    i--;
                }
                else if(tempI + tempJ ==0){
                    String s = tempI + "" + tempJ;
                    if (!set.contains(s)) {
                        result.add(Arrays.asList(tempI, 0, tempJ));
                        set.add(s);
                    }
                    i--;
                    j++;
                }
                else{
                    j++;
                }
            }
        }
        return result;

    }
}
