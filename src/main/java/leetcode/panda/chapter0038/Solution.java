package leetcode.panda.chapter0038;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    /**
     * conway数组：后一个数列由前一个数列去统计计数组成：利用这一思想循环遍历由前及后
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String[] conways = new String[n];
        conways[0] = "1";
        for(int i = 1; i < n; i++){
            conways[i] = generateNextConway(conways[i-1]);
        }
        return conways[n-1];
    }

    private static String generateNextConway(String pre){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = pre.charAt(0);
        int length = pre.length();
        for(int i = 1; i < length; i++){
            if(ch != pre.charAt(i)){
                sb.append(count).append(ch);
                count=1;
                ch = pre.charAt(i);
            }
            else{
                count++;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }

}
