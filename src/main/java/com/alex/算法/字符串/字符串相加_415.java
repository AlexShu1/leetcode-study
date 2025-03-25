package com.alex.算法.字符串;

/**
 * 描述
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * Related Topics
 * 数学
 * 字符串
 * 模拟
 *
 * @auth shufei
 * @date 2025/3/5
 */
public class 字符串相加_415 {

    public static void main(String[] args) {
        字符串相加_415 call = new 字符串相加_415();
        String rest = call.addStrings("456", "77");
        System.out.println(rest);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        // 从低位开始进行相加
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            // 余数
            ans.append(result % 10);
            // 进位
            add = result / 10;
            i--;
            j--;
        }
        // 因为是从个位数开始进行相加.  翻转过来数据才是正确的.
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
