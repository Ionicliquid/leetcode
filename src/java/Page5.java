package java;


//1. 206. 反转链表                    A
//2. 215. 数组中的第K个最大元素         A 交换完成 继续维护堆性质;
//3. 230. 二叉搜索树中第K小的元素        A
//4. 232. 用栈实现队列                 A
//5. 234. 回文链表                    A
//6. 235. 二叉搜索树的最近公共祖先        A
//7. 236. 二叉树的最近公共祖先           A
//8. 260. 只出现一次的数字 III          A
//9. 268. 丢失的数字                   A
//10. 297. 二叉树的序列化与反序列化  
//11. 315. 计算右侧小于当前元素的个数
//12. 322. 零钱兑换                   A
//13. 329. 矩阵中的最长递增路径
//14. 343. 整数拆分
//15. 347. 前 K 个高频元素            A
//16. 365. 水壶问题
//17. 386. 字典序排数
//18. 387. 字符串中的第一个唯一字符     A
//19. 403. 青蛙过河
//20. 410. 分割数组的最大值
//1.    470 用Rand7()实现Rand10()
//2.	Offer24-反转链表            A
//3.	69 x的平方根       
//4.	83 删除链表中的重复元素       A
//5.	94 二叉树的中序遍历          A
//6.	176  第二高的薪水           A
//8.	198 打家劫舍             A
//9.	48 旋转图像              A
//10.	384 打乱数组
//11.	494 目标和
//12.	31 下一个排列               A
//13.	204 计数质数
//14.	35 搜索插入位置          A
//15.	63 不同路径Ⅱ
//16.	112 路径总和              
//17.	222 完全二叉树的节点个数
//18.	225 用队列实现栈               A
//19.	217 存在重复元素               A
//20.	152 乘积最大子数组              A


import javabean.ListNode;
import javabean.TreeNode;

import java.util.*;

public class Page5 {


    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = row + (col - 1) * 7;

        } while (idx > 40);
        return 1 + (idx - 1) % 10;

    }

    private int rand7() {
        return 0;
    }


    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 1) {
                dp[0] = nums[i];
            } else if (i == 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }


        }

        return dp[nums.length - 1];

    }

}

