package com.alex.算法.栈;

import java.util.*;

/**
 * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 */
public class 有效的括号_20 {
    public boolean isValid(String s) {
        int n = s.length();
        // 括号匹配肯定是偶数
        if (n % 2 == 1) {
            return false;
        }

        // 事先确定匹配的括号
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                // 如果存在Map中, 那么, stack必须有数据, 或者栈顶元素一定要和当前括号一样;
                // 否则都可以认为是不匹配的括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }

                // 反之, 认为是匹配的, 则弹出左括号
                stack.pop();
            } else {
                // 左括号都进行压栈
                stack.push(ch);
            }
        }

        // 最后若栈不为空, 则括号不匹配
        return stack.isEmpty();
    }
}
