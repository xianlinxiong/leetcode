package leetcode.panda.chapter0004;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums1= {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 利用有序数组合并思想：移动两个数组指针到固定位置
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i =0;
        int j = 0;
        int index = 0;
        int target = (nums1.length +nums2.length)/2;
        boolean even =(nums1.length + nums2.length)%2 == 0;
        int first = 0;
        int second = 0;
        while(i < nums1.length && j < nums2.length && index <= target){
            first = second;
            if(nums1[i] < nums2[j]){
                second = nums1[i];
                i++;
            }else{
                second =nums2[j];
                j++;
            }
            index++;
        }
        while(i < nums1.length && index <= target){
            first = second;
            second = nums1[i];
            i++;
            index++;
        }
        while(j < nums2.length && index <= target){
            first = second;
            second = nums2[j];
            j++;
            index++;
        }
        if(even){
            return (first + second) /2.0;
        }else{
            return second;
        }

    }
}
