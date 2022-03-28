package main.java.leetcode.algorithm.topics;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class Topic6 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 时间：O(n2)
     * 空间：O(1)
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            } else {
                int j = i + 1;
                while (j < n) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    } else {
                        j++;
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 时间：O(n)
     * 空间：O(1)
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int i = 0; int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
            j++;
        }
    }
    
}
