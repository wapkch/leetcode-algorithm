package main.java.leetcode.algorithm.topics;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false 
 * 调用 isBadVersion(5) -> true 
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 
 * 思路：
 * - 二分法
 *   1. 如果isBadVersion(mid) -> true, 向左找isBadVersion=false的版本
 *   2. 如果isBadVersion=false，向右找isBadVersion=true的版本
 *   3. 当left=right时，如果此时isBadVersion=true，则return mid -1；如果isBadVersion=false，则return mid。
 */
public class Topic2 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(4));
    }
    
        public static int firstBadVersion(int n) {
            int left = 1;
            int right = n;

            int mid = 0;
    
            while(left <= right) {
                mid = left + (right - left) / 2;

                if (left == right) {
                    if (isBadVersion(mid)) {
                        return mid;
                    } else {
                        return mid + 1;
                    }
                }
                
                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return mid;
        }

        private static boolean isBadVersion(int mid) {
            return mid >= 4 ? true : false;
        }

}
