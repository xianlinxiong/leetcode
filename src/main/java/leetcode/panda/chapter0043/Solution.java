package leetcode.panda.chapter0043;

import java.util.Arrays;

/**
 *给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 贡献者
 *
 */
public class Solution {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiply(num1, num2));
    }


    /**
     * 手动计算乘法，用result记录结果，取模回存result，next保存进位
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1+length2+2];
        Arrays.fill(result, 0);
        int start = 0;
        for(int i =length2-1; i>=0; i--){
            int next = 0;
            int k =0;
            for(; k <= length1-1; k++){
                int ki = num2.charAt(i)-'0';
                int kj = num1.charAt(length1-1-k)-'0';
                int temp = start+k;
                int num = ki*kj + result[temp] + next;
                result[temp] = num % 10;
                next = num/10;
            }
            if(next > 0) {
                result[start + k] = result[start + k] + next;
            }
            start++;
        }
        int end = result.length - 1;
        while(result[end] ==0 && end > 0){
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = end; i>=0; i--){
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
