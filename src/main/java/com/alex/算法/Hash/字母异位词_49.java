package com.alex.算法.Hash;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class 字母异位词_49 {

    public static void main(String[] args) {
        字母异位词_49 call = new 字母异位词_49();

        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat", "tab"};
        List<List<String>> anagrams = call.groupAnagrams(strs);
        System.out.printf("[");
        for (List<String> anagramItem : anagrams) {
            System.out.printf("[");
            for (String item : anagramItem) {
                System.out.printf(item + ", ");
            }

            System.out.println("]");
        }

        System.out.println("]");
    }

    /**
     * 核心思想: 就是通过遍历每一个str, 进行字符串排序, 然后，若顺序一致, 则认为单词的字母都是一样的.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
