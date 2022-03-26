package main.java.leetcode.algorithm.topics;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 * 
 * 提示：
 * 1. 你可以假设 nums 中的所有元素是不重复的。
 * 2. n 将在 [1, 10000]之间。
 * 3. nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Topic1 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0,3,5,6,8,10,12};
        System.out.println(search(nums, 9));;
    }
    
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 可能存在数据溢出
            // int mid = (left + right) / 2; 
            
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
