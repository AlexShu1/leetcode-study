package com.alex.java基础;

public class Try_finally_return_test {

    public static void main(String[] args) {
        int res = test();
        System.out.println(res);
    }

    private static int test() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }
}
