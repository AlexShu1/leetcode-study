package com.alex.算法.算法题;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class 有效的回文_18 {

    public static void main(String[] args) {
        有效的回文_18 call = new 有效的回文_18();
        boolean palindrome = call.isPalindrome("");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        StringBuilder append = new StringBuilder();
        for (char item : s.toCharArray()) {
            append.append(item);
        }

        String newStr = new StringBuilder(append).reverse().toString();
        return append.toString().equalsIgnoreCase(newStr);
    }
}
