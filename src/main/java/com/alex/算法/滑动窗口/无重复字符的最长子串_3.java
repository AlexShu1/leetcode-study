package com.alex.算法.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
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
 */
public class 无重复字符的最长子串_3 {

    public static void main(String[] args) {
        无重复字符的最长子串_3 call = new 无重复字符的最长子串_3();
        int lengthOfLongestSubstring = call.lengthOfLongestSubstring("abcabcbb");
        System.out.println(lengthOfLongestSubstring);
    }


    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 不断的移除SET中的元素, 这样就能知道每个元素开头的最长子串情况.
                occ.remove(s.charAt(i - 1));
            }

            // 不断的尝试最长子串; 若元素重复出现则认为已经重复了.
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

