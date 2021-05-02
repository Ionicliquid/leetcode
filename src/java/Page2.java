package java;
//1.    11.盛水最多的容器                 A
//2.	136.只出现一次的数字              A
//3.	72.编辑距离                     A
//4.	43.字符串相乘                   A
//5.	26 删除排序数组的重复项            A
//6.	344.反转字符串                       A
//7.	23.合并K个有序链表                    A
//8.	46.全排列                             A
//9.	54.螺旋矩阵                            A
//10.	42.接雨水                        A
//11.	148.排序链表                      A
//12.	887.鸡蛋掉落               
//13.	121.买卖股票的最佳时机              A
//14.	292 Nim游戏                       A
//15.	88.合并2个有序数组               A
//16.	104 二叉树的最大深度                A
//17.	19 删除链表的倒数第N个节点         A
//18.	25 k个一组翻转链表        
//19.	237 删除链表中的节点         A
//20.	300.最长递增子序列              A

//1. 34. 在排序数组中查找元素的第一个和最后一个位置
//2. 35. 搜索插入位置           A
//3. 38. 外观数列
//4. 39. 组合总和               A
//5. 40. 组合总和 II           A
//6. 42. 接雨水                A
//7. 46. 全排列                A
//8. 47. 全排列 II             A
//9. 48. 旋转图像             A
//10. 50. Pow(x, n)              A
//11. 51. N 皇后
//12. 53. 最大子序和       A
//13. 54. 螺旋矩阵           A
//14. 55. 跳跃游戏         A
//15. 56. 合并区间          A
//16. 62. 不同路径        A
//17. 70. 爬楼梯          A
//18. 71. 简化路径         A
//19. 72. 编辑距离         A
//20. 74. 搜索二维矩阵      A

import javabean.ListNode;

import java.util.*;

public class Page2 {


    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                ans = Math.max(leftMax, rightMax) - height[left++];

            } else {
                rightMax = Math.max(right, height[right]);
                ans = Math.max(leftMax, rightMax) - height[right--];
            }

        }
        return ans;

    }


    public void rotate(int[][] matrix) {

        int m = matrix.length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans++;
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                nums[ans] = nums[i];
            } else {
                ans++;
            }

        }
        return ans;

    }

    public boolean canJump(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= nums.length - 1) return true;
            if (max<i){
                return false;
            }
            max = Math.max(i + nums[i], max);
        }
        return true;


    }


}
