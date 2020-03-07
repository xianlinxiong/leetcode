package leetcode.panda.chapter0012;

public class Solution {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(intToRoman(3999));
    }

    //主要除法和取余， 重点关注4,9
    public static String intToRoman(int num) {
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] r = {1000, 500, 100, 50, 10, 5, 1};
        StringBuilder sb = new StringBuilder();
        int size = r.length;
        int k = num / r[0];
        num %= r[0];
        for(int i =0; i < k; i++){
            sb.append(roman[0]);
        }

        for(int m =2; m < size; ){
            int s = num /r[m];
            num %= r[m];
            if(s == 9){
                sb.append(roman[m]).append(roman[m-2]);
            }
            else if(s == 4){
                sb.append(roman[m]).append(roman[m-1]);
            }
            else{
                if(s >= 5){
                    sb.append(roman[m-1]);
                    s -= 5;
                }
                for(int i =0; i < s; i++){
                    sb.append(roman[m]);
                }
            }
            m += 2;
        }
        return sb.toString();

    }



}
