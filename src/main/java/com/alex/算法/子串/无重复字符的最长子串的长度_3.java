package com.alex.算法.子串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * Related Topics
 * 哈希表
 * 字符串
 * 滑动窗口
 *
 * @auth shufei
 * @date 2025/2/27
 */
public class 无重复字符的最长子串的长度_3 {

    public static void main(String[] args) {
        无重复字符的最长子串的长度_3 call = new 无重复字符的最长子串的长度_3();
        int lengthOfLongestSubstring = call.lengthOfLongestSubstringV2("abcabcdbb");
        System.out.println(lengthOfLongestSubstring);

        call.subMaxLength("abcabcdbb");
//        String substring =
//        System.out.println(substring);
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        // 左指针是i; 右指针是rk
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符;
                // 因为上一个循坏确认了i-1和rk+1的元素重复了; 因此, 需要先删除i-1的元素; 这样才能迭代下一个子串.
                occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针, 当rk+1的元素出现在了SET中, 则认为, 出现了重复的元素; 子串终止.
                occ.add(s.charAt(rk + 1));
                ++rk;
            }

            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstringV2(String s) {
        Set<Character> occ = new HashSet<>();
        int rk = -1, ans = 0, n = s.length();
        // 1.遍历字符串的每个字符
        for (int i = 0; i < n; i++) {
            // 需要移动左边界
            if (i != 0) {
                // 因为SET无序, 只能删除元素; 这个元素也就是重复的那个字符
                occ.remove(s.charAt(i - 1));
            }

            // 2.校验子串是否重复
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }

            // 3.比较Max, 得到最大子串
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public int subMaxLength(String s) {
        List<Character> occ = new ArrayList<>(s.length());
        List<Character> res = new ArrayList<>(s.length());
        int rk = -1, ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                Character charAt = s.charAt(i - 1);
                occ.remove(charAt);
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }

            if (ans < rk - i + 1) {
                res = new ArrayList<>();
                res.addAll(occ);
            }
            ans = Math.max(ans, rk - i + 1);
        }

        System.out.println(ans);
        System.out.println(res);
        return ans;
    }
}

