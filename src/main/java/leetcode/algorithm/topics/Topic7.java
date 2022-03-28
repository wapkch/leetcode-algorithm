package main.java.leetcode.algorithm.topics;

import java.util.Arrays;

import org.omg.PortableInterceptor.IORInfo;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 
 * 思路：
 * 如果是无序数组，有两种办法：
 * 1. 使用时间复杂度为O(n2), 空间复杂度为O(1)暴力求解
 * 2. 使用哈希表，时间复杂度为O(n), 空间复杂度为O(n)
 * 
 * 对于有序数组，可以充分利用有序特性，有两种方法：
 * 1. 二分法
 * 2. 双指针
 */
public class Topic7 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }
    
    /**
     * 二分法
     * 时间复杂度：O(n \log n)O(nlogn)，其中 nn 是数组的长度。需要遍历数组一次确定第一个数，时间复杂度是 O(n)O(n)，
     * 寻找第二个数使用二分查找，时间复杂度是 O(\log n)O(logn)，因此总时间复杂度是 O(n \log n)O(nlogn)。
     * 
     * 空间复杂度：O(1)。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == t) {
                    return new int[]{i, mid};
                } else if (numbers[mid] < t) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return null;
    }

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int i = 0; int j = numbers.length - 1;
        while (i <= j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i, j};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

}
