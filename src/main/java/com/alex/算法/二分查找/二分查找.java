package com.alex.算法.二分查找;

public class 二分查找 {

    public static void main(String[] args) {
        二分查找 call = new 二分查找();
        int[] nums = new int[] {1, 3, 6, 10, 16};
        boolean res = call.binarySearch(nums, 2);
        System.out.println(res);
    }

    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
