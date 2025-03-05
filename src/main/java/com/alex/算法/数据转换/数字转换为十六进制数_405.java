package com.alex.算法.数据转换;

/**
 * 描述
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。
 *
 * 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。
 *
 * 示例 1：
 *
 * 输入：num = 26
 * 输出："1a"
 * 示例 2：
 *
 * 输入：num = -1
 * 输出："ffffffff"
 * 提示：
 *
 * -231 <= num <= 231 - 1
 * Related Topics
 * 位运算
 * 数学
 *
 * @auth shufei
 * @date 2025/3/5
 */
public class 数字转换为十六进制数_405 {

    public static void main(String[] args) {
        数字转换为十六进制数_405 call = new 数字转换为十六进制数_405();
        String hex = call.toHex(26);
        System.out.println(hex);
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
