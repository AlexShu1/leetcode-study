package com.alex.算法.子串;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 * Related Topics
 * 字典树
 * 字符串
 *
 * @auth shufei
 * @date 2025/3/3
 */
public class 最长公共前缀_14 {
    public static void main(String[] args) {
        最长公共前缀_14 call = new 最长公共前缀_14();
        String[] strs = {"flower", "flow", "flight"};
        String rest = call.longestCommonPrefix(strs);
        System.out.println(rest);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        // 第一个字符串进行遍历
        for (int i = 0; i < length; i++) {
            // 得到第一个字符串的每个字符
            char c = strs[0].charAt(i);
            // 数组的长度进行遍历(第一个是外循环); 这样就一次性遍历了n个字符串
            for (int j = 1; j < count; j++) {
                // i == strs[j].length(): 说明其中一个字符串已经到结尾位置了, 可以进行返回了
                // strs[j].charAt(i) != c: 说明某个字符串所处的char和其他的字符串前缀已经存在不同了, 可以进行返回了。
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // 若第一个字符串都遍历完成,还是没有return, 那么, 可以直接认定第一个字符串就是最长前缀
        return strs[0];
    }
}
