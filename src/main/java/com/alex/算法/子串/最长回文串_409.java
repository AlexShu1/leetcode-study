package com.alex.算法.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输出:1
 * 解释：可以构造的最长回文串是"a"，它的长度是 1。
 * 提示:
 * <p>
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 * Related Topics
 * 贪心
 * 哈希表
 * 字符串
 *
 * @auth shufei
 * @date 2025/3/4
 */
public class 最长回文串_409 {

    public static void main(String[] args) {
        最长回文串_409 call = new 最长回文串_409();
        int res = call.longestPalindrome("abccccdd");
        System.out.println(res);
    }

    public int longestPalindrome(String s) {
        // 统计各字符数量
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            counter.merge(s.charAt(i), 1, (a, b) -> a + b);
        // 统计构造回文串的最大长度
        int res = 0, odd = 0;
        for (Map.Entry<Character, Integer> kv : counter.entrySet()) {
            // 将当前字符出现次数向下取偶数，并计入 res
            int count = kv.getValue();
            int rem = count % 2;
            res += count - rem;
            // 若当前字符出现次数为奇数，则将 odd 置 1
            if (rem == 1) odd = 1;
        }

        return res + odd;
    }

}
