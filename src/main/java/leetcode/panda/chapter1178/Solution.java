package leetcode.panda.chapter1178;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 * <p>
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * <p>
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 * 提示：
 * <p>
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println(s.findNumOfValidWords(words, puzzles));


    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        List<Set<Character>> wordList = new ArrayList<>();
        for (String word : words) {
            Set<Character> ss = new HashSet<>();
            for (char c : word.toCharArray()) {
                ss.add(c);
            }
            wordList.add(ss);
        }
        for (String puzzle : puzzles) {
            int cnt = 0;
            Set<Character> pp = new HashSet<>();
            for (char c : puzzle.toCharArray()) {
                pp.add(c);
            }
            for (Set<Character> characterSet : wordList) {
                if (isPuzzle(characterSet, pp, puzzle.charAt(0))) {
                    cnt++;
                }
            }
            res.add(cnt);
        }

        return res;
    }

    private boolean isPuzzle(Set<Character> w, Set<Character> p, char ch) {
        return w.contains(ch) && p.containsAll(w);
    }

}