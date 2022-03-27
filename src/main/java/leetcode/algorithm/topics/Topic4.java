package main.java.leetcode.algorithm.topics;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * 
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class Topic4 {
    
    /**
     * 方法一：
     * 1. 找到负数和正数临界点
     * 2. 分别向外移动双向指针
     * 3. 对比指针指向值，取小值对应指针继续移动
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int neg = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }

        int i = neg; 
        int j = neg + 1;
        int k = 0;
        while (i >= 0 || j < nums.length) {
            if (i < 0) {
                ans[k] = nums[j] * nums[j];
                j++;
            } else if (j == nums.length) {
                ans[k] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                ans[k] = nums[i] * nums[i];
                i--;
            } else {
                ans[k] = nums[j] * nums[j];
                j++;
            }
            k++;
        }
        
        return ans;
    }

    /**
     * 方法二：
     * 1. 从最左端和最右端向内移动双指针
     * 2. 对比指针指向值，取大值对应指针继续移动
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        int[] ans = new int[nums.length];

        int i = 0; 
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                ans[k] = nums[j] * nums[j];
                j--;
            } else {
                ans[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = sortedSquares(new int[]{-4,-1,0,0,3,10});
        System.out.println(Arrays.toString(ans));
    }

}
