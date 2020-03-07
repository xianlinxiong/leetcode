package leetcode.panda.chapter0009;

class Solution {
    //直接接字符串反转，比较相等
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }

        String origin = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            sb.append(x%10);
            x = x/10;
        }
        return origin.equals(sb.toString());

    }
}