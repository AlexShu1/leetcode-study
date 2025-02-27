package com.alex.算法.子串;

import java.util.ArrayList;
import java.util.List;

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
public class 无重复字符的最长子串的子串_3 {

    public static void main(String[] args) {
        无重复字符的最长子串的子串_3 call = new 无重复字符的最长子串的子串_3();
        call.subMaxLength("abcabcdbb");
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
                // 需要保证每次有更大的子串的时候, 重新Create res; 否则数据就是不断追加了.
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

