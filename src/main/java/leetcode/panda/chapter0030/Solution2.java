package leetcode.panda.chapter0030;

import java.util.*;

/**
 * 进阶:（全排列方法失败，数量级较多）; 采用数组标记算法，比较时移动length为固定位置
 *
 */
public class Solution2 {
    public static void main(String[] args) {

        Solution2 s = new Solution2();
//        String ss = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String words[] ={"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String ss = "wordgoodgoodgoodbestword" ;
        String[] words = {"word","good","best","good"};
        System.out.println(s.findSubstring(ss, words));
//        System.out.println(strStr("hello", "hello"));
    }
    public Solution2(){

    }

        public List<Integer> findSubstring(String s, String[] words) {
            if(s == null || s.length() == 0 || words == null || words.length ==0){
                return Collections.emptyList();
            }
            List<Integer> results = new ArrayList<>();
            Map<String, Integer> wordMap = new HashMap<>();
            for(String str : words){
                wordMap.put(str, wordMap.getOrDefault(str, 0)+1);
            }
            int wordLength = words[0].length();
            int subStrLength = wordLength * words.length;
            Map<String, Integer> tempMap = new HashMap<>();
            for(int i =0; i< s.length()-subStrLength +1; i++){
                tempMap.clear();
                int count = words.length;
                for(int j =i; j<= s.length()-wordLength*count && count > 0; j=j+wordLength){
                    String subString = s.substring(j, j+wordLength);
                    if(!wordMap.containsKey(subString)){
                        break;
                    }
                    int wCount = wordMap.get(subString);
                    int currentCount = tempMap.getOrDefault(subString, 0);
                    if(wCount == currentCount){
                        break;
                    }
                    tempMap.put(subString, currentCount+1);
                    count--;
                }

                if(count ==0){
                    results.add(i);
                }

            }
            return results;
        }

}
