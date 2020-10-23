package leetcode.panda.chapter0006;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        String result = solution2.convert("LEETCODEISHIRING", 4);
        System.out.println(result.equals("LDREOEIIECIHNTSG"));
        assert result.equals("LDREOEIIECIHNTSG");
    }

    /**
     * 数学规律推算：从下往上Z字形跟行数关系如下：
     *  一个循环 round = 2*N -2；
     *  当index = k*round + m（m>=0, m < N） 时， 该元素在第m+1行
     *  当index = k*round - m时，该元素在第m+1行
     *  当index
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows <=1){
            return s;
        }
       StringBuilder sb = new StringBuilder();
       int round = 2 * numRows -2;
       int count = s.length() / round +1;

       for(int k = 0; k < numRows; k++){
           for(int i =0; i < count; i++){
               int index = i * round;
               int first = index + k;
               if(first < s.length()){
                   sb.append(s.charAt(first));
               }
               int second = index + 2 * numRows-2 -k;
               if(k!=0 && k!=(numRows-1) && second < s.length()){
                   sb.append(s.charAt(second));
               }
           }
       }

       return sb.toString();
    }
}
