package main.java.leetcode.algorithm.topics;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 * 
 * 思路：
 * - 二分法：
 *   1. 如果mid=target，返回mid；
 *   2. 如果mid<target, 向右查询
 *   3. 如果mid>target, 向左查询
 *   4. 
 */
public class Topic3 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{0,1,3,5,6,7,8}, 2));
    }
    
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (left == right) {
                if (nums[mid] < target) {
                    return mid + 1;
                } else {
                    return mid;
                }
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return mid - 1;
    }

}
