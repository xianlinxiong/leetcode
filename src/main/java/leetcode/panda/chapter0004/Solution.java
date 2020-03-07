package leetcode.panda.chapter0004;

class Solution {
    //比较大小，两边移步
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (null == nums1 || 0 == nums1.length) {
            return getMedian(nums2);
        } else if (null == nums2 || 0 == nums2.length) {
            return getMedian(nums1);
        }
        int cnt = (nums1.length + nums2.length) / 2 +1;
        int min1, min2, max1, max2,m;
        int min=0, max=0;
        for (min1 = 0, min2 = 0,max1=nums1.length-1,max2=nums2.length-1, m = 1; m < cnt; m++) {
            if(min1 >max1){
                min = nums2[min2++];
                max = nums2[max2--];
            }
            else if(min2 > max2){
                min = nums1[min1++];
                max = nums1[max1--];
            }
            else{
                if(nums1[min1] < nums2[min2]){
                    min = nums1[min1++];
                }
                else{
                    min = nums2[min2++];
                }
                if(min1 > max1){
                    max = nums2[max2--];
                }
                else if(min2 > max2){
                    max = nums1[max1--];
                }
                else{
                    if (nums1[max1] > nums2[max2]){
                        max = nums1[max1--];
                    }
                    else{
                        max = nums2[max2--];
                    }
                }
            }
            if(max == min){
                break;
            }
        }
        //边界值：长度为偶数
        if((nums1.length + nums2.length)%2 == 0) {
            return (max + min) / 2.0;
        }
        else{
            //长度为奇数，多计算一次
            if(min1 > max1){
                return nums2[min2];
            }
            else if(min2 > max2){
                return nums1[min1];
            }
            else{
                return nums1[min1] < nums2[min2] ? nums1[min1]: nums2[min2];
            }
        }


    }

    //单数组寻找 中位数
    static double getMedian(int num[]) {
        if (null == num || 0 == num.length) {
            return 0.0;
        }
        int size = num.length;
        if (0 == size % 2) {
            return (num[size / 2] + num[size / 2 - 1]) / 2.0;
        } else {
            return num[(size - 1) / 2];
        }
    }

}