package leetcode.panda.chapter0007;

class Solution {
    //用k标记正负情况，overflow标记越界，利用除法和取余反转
    public int reverse(int x) {
        int max = Integer.MAX_VALUE /10;
        int min = Integer.MIN_VALUE/10;
        int k;
        k = x < 0 ? -1 : 1;
        x *= k;
        int result = 0;
        boolean overflow = false;
        while(x > 0 && !overflow){
            int n = x % 10;
            result = result*10 +n;
            if(result* k > max || result*k < min){
                overflow = true;
            }
            x /= 10;
        }
        if(x >0){
            return 0;
        }
        return k * result;
    }
}