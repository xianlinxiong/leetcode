package leetcode.panda.chapter0010;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isMatch("a", "ab*a"));
    }
    public static boolean isMatch(String s, String p) {

        return doMatch(s, 0, p, 0);
    }

    public static boolean doMatch(String s, int sStart, String p, int pStart) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == sStart) {
            if (p.length() == pStart) {
                return true;
            }
            else if(p.length() > pStart+1 && p.charAt(pStart+1)=='*'){
                return doMatch(s, sStart, p, pStart+2);
            }
            else {
                return false;
            }
        } else {
            if (p.length() == pStart) {
                return false;
            } else {
                if (p.charAt(pStart) == '.') {
                    if (pStart + 1 == p.length() || p.charAt(pStart + 1) != '*') {
                        return doMatch(s, sStart + 1, p, pStart + 1);
                    } else {
                        int newStart = sStart;
                        while (newStart <= s.length()) {
                            if (doMatch(s, newStart, p, pStart + 2)) {
                                return true;
                            }
                            newStart++;
                        }
                        return false;
                    }
                } else {
                    if (pStart + 1 == p.length() || p.charAt(pStart + 1) != '*') {
                        return s.charAt(sStart) == p.charAt(pStart) && doMatch(s, sStart + 1, p, pStart + 1);
                    } else {
                        int newStart = sStart;
                        while (newStart <= s.length()) {
                            if (doMatch(s, newStart, p, pStart + 2)) {
                                return true;
                            }
                            if(s.length() == newStart || s.charAt(newStart) != p.charAt(pStart)){
                                return false;
                            }
                            newStart++;
                        }
                        return false;
                    }
                }
            }
        }
    }
}
