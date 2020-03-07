package leetcode.panda.chapter0013;

public class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    // 重点关注偶数位置的数，以及下一位置
    public static int romanToInt(String s) {
        String roman = "MDCLXVI";
        int[] r = {1000, 500, 100, 50, 10, 5, 1};
        int size = s.length();
        int result = 0;
        for(int i = 0; i < size; i++){
            int k = roman.indexOf(s.charAt(i));
            if(k == 0 || k %2 == 1){
                result += r[k];
            }
            else{
                //边界点判断
                if(i == size -1){
                    result += r[k];
                    break;
                }
                int j = roman.indexOf(s.charAt(i+1));
                if(j < k){
                    result += r[j] - r[k];
                    i++;
                }
                else{
                    result += r[k];
                }
            }
        }

        return result;
    }



}
