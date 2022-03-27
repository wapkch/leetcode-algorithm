package main.java.leetcode.algorithm.topics;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 
 * 进阶：
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class Topic5 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        nums = rotate1(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 本质是将元素i --> 元素(i+k)%n 
     * 
     * @param nums
     * @param k
     */
    public static int[] rotate1(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[(i + k) % nums.length] = nums[i];
        }
        return ans;
    }
    
    /**
     * 方法一中使用额外数组的原因在于如果我们直接将每个数字放至它最后的位置，这样被放置位置的元素会被覆盖从而丢失。因此，从另一个角度，我们可以将被替换的元素保存在变量 \textit{temp}temp 中，从而避免了额外数组的开销。
     * 
     * 时间：O(n)
     * 空间：O(1)
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;

        int count = 0;
        int start = 0;
        while (count < n) {
            int innerCount = 0;
            int current = start;
            int prev = nums[current];                
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                if (innerCount == 0) {
                    count = count + 2;
                } else {
                    count ++;
                }

                current = next;
                next = (current + k) % n;
                innerCount ++;
            } while(start != current);
            start ++;
        }
    }

    /**
     * 该方法基于如下的事实：当我们将数组的元素向右移动 kk 次后，尾部 k\bmod nkmodn 个元素会移动至数组头部，其余元素向后移动 k\bmod nkmodn 个位置。
     * 该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k\bmod nkmodn 个元素就被移至数组头部，然后我们再翻转 [0, k\bmod n-1][0,kmodn−1] 区间的元素和 [k\bmod n, n-1][kmodn,n−1] 区间的元素即能得到最后的答案。
     * 
     * 例如：
     * [1,2,3,4,5,6,7,8] <--> [8,7,6,5,4,3,2,1]
     * --> k=2
     * [7,8,1,2,3,4,5,6]
     *
     * 
     * 时间：O(2n)
     * 空间：O(1)
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];

            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }
        
    }

}
