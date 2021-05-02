package java;
//1.    89 格雷编码 
//2.	Offer 09 用2个栈实现队列        A
//3.	10 正则表达式匹配  
//4.	59 螺旋矩阵Ⅱ                  A
//5.	105 从前序与中序遍历序列构造二叉树 
//6.	124 二叉树中的最大路径和     A
//7.	236 二叉树的最近公共祖先      A
//8.	322 零钱兑换                A
//9.	160 相交链表                 A
//10.	50 Pow(x,y)                A
//11.	78 子集                        A
//12.	200 岛屿数量                  A
//13.	230 二叉搜索树中的第K小元素    A
//14.	347 前K个高频元素            A
//15.	14 最长公共前缀              A
//16.	144 二叉树的前序遍历         A
//17.	155 最小栈                 A
//18.	415 字符串相加             A
//19.	22 括号生成                  A
//20.	6 Z 字形变换                 A  处理numRows==1的情况


//1. 79. 单词搜索                   
//2. 82. 删除排序链表中的重复元素 II   
//3. 83. 删除排序链表中的重复元素       
//4. 84. 柱状图中最大的矩形
//5. 88. 合并两个有序数组                 A
//6. 90. 子集 II                    
//7. 98. 验证二叉搜索树                  A
//8. 102. 二叉树的层序遍历                A
//9. 103. 二叉树的锯齿形层序遍历           A
// 后序遍历
//10. 104. 二叉树的最大深度               A
//11. 105. 从前序与中序遍历序列构造二叉树 
//12. 107. 二叉树的层序遍历 II            A
//13. 108. 将有序数组转换为二叉搜索树      A
//14. 110. 平衡二叉树              
//15. 112. 路径总和              
//16. 114. 二叉树展开为链表
//17. 120. 三角形最小路径和
//18. 121. 买卖股票的最佳时机             A
//19. 122. 买卖股票的最佳时机 II          A
//20. 126. 单词接龙 II


import javabean.ListNode;
import javabean.TreeNode;

import java.util.*;

public class Page3 {


    // Pow(x,n)
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1.0;
        double pow = pow(x, n / 2);
        return n % 2 == 0 ? pow * pow : pow * pow * x;
    }


    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);

        ans = Math.max(ans, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

}
