package com.alex.算法.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @auth shufei
 * @date 2025/3/1
 */
public class Z字形变换_6 {

    /**
     * 解题思路:
     * 字符串 s 是以 Z 字形为顺序存储的字符串，目标是按行打印。
     * <p>
     * 设 numRows 行字符串分别为 s
     * ，则容易发现：按顺序遍历字符串 s 时，每个字符 c 在 N 字形中对应的 行索引 先从 s1 增大至 sn
     * ，再从 sn 减小至 s1
     * …… 如此反复。
     * 因此解决方案为：模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i] 。
     */

    public static void main(String[] args) {
        Z字形变换_6 call = new Z字形变换_6();
        String resStr = call.convertV2("PAYPALISHIRING", 3);
        System.out.println(resStr);
    }

    public String convert(String s, int numRows) {
        // 如果小于2行, 那么, 直接返回本身即可
        if (numRows < 2) return s;

        // 创建numRows行StringBuilder
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        // 遍历字符串的每一个字符
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            // 核心点: 在0和最后一行的时候, 都需要逆反增加i或者减少i; 保证是按照从上到下, Z字型的存储方式.
            if (i == 0 || i == numRows - 1) {
                // i=0的时候, 需要i持续增加;
                // 当i==最后一行的时候, 需要i持续减少;
                // 最终达到Z字型存储的效果.
                flag = -flag;
            }

            i += flag;
        }

        // 把List中的每一行全部连接在一起.
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public String convertV2(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        // 1.存储数据容器初始化
        List<StringBuilder> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }

        // 2.遍历字符串
        int i = 0, flag = -1;
        for (char item : s.toCharArray()) {
            res.get(i).append(item);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }

            i += flag;
        }

        StringBuilder resStr = new StringBuilder();
        for (StringBuilder item : res) {
            resStr.append(item);
        }

        return resStr.toString();
    }
}
