package bytedance

import bean.TreeNode

//1. 79. 单词搜索
//2. 82. 删除排序链表中的重复元素 II
//3. 83. 删除排序链表中的重复元素
//4. 84. 柱状图中最大的矩形
//5. 88. 合并两个有序数组
//6. 90. 子集 II
//7. 98. 验证二叉搜索树
//8. 102. 二叉树的层序遍历              - 完成
//9. 103. 二叉树的锯齿形层序遍历
//10. 104. 二叉树的最大深度            - 完成
//11. 105. 从前序与中序遍历序列构造二叉树
//12. 107. 二叉树的层序遍历 II
//13. 08. 将有序数组转换为二叉搜索树
//14. 110. 平衡二叉树
//15. 112. 路径总和
//16. 114. 二叉树展开为链表
//17. 120. 三角形最小路径和
//18. 121. 买卖股票的最佳时机
//19. 122. 买卖股票的最佳时机 II         - 完成
//20. 126. 单词接龙 II


fun maxDepth(root: TreeNode?): Int {



    if (root == null) {
        return 0
    }

    return maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1

}


fun levelOrder(root: TreeNode?): List<List<Int>> {

    var ans = mutableListOf<List<Int>>()
    if (root == null) {
        return ans
    }
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    while (!queue.isEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 0 until size) {
            var node = queue.removeFirst()
            if (node.left != null) {
                queue.addLast(node.left!!)
            }
            if (node.right != null) {
                queue.addLast(node.right!!)
            }
            list.add(node.`val`)
        }
    }
    return ans


}


fun maxProfit2(prices: IntArray): Int {

    var ans = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1]

    }

    return ans

}