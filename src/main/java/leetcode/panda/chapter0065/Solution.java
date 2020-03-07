package leetcode.panda.chapter0065;

/**
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.isNumber("1"));
    }

    public boolean isNumber(String s) {

        return doCheck(s.trim(), 0, false, false, false);
    }

    /**
     *  验证数字：按e切分
     * @param s 待验证串
     * @param cur 当前位置
     * @param hasE  是否有e
     * @param hasP  是否有小数点
     * @param hasNum    是否已经包含数字
     * @return
     */
    private boolean doCheck(String s, int cur, boolean hasE, boolean hasP, boolean hasNum) {
        //s为空，或者已经到达尾部节点
        if (s == null || s.length() == cur) {
            return false;
        }
        //跳过开始位置的+、-号
        char ch = s.charAt(cur);
        if (ch == '-' || ch == '+') {
            cur++;
        }
        //循环遍历
        while (cur < s.length()) {
            ch = s.charAt(cur);
            //发现. hasP只有一次
            if (ch == '.') {
                if (hasP) {
                    return false;
                }

                hasP = true;
            } else if (ch == 'e') {
                //发现e hasE只有一次，后续必须全是数字
                if (hasE) {
                    return false;
                }
                return hasNum && doCheck(s, cur + 1, true, true,false);

            } else if (ch < '0' || ch > '9') {//非0-9
                return false;
            } else {
                hasNum = true;
            }
            cur++;
        }
        return hasNum;
    }
}