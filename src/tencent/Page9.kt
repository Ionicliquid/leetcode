package tencent

import bean.ListNode
import bean.TreeNode
import java.util.ArrayDeque


//1.    1114 按序打印 -完成
//2.	118 杨辉三角  -完成
//3.	1024 视频拼接
//4.	233 数字1的个数
//5.	110 平衡二叉树 -完成
//6.	32 最长有效括号
//7.	40 组合总和Ⅱ
//8.	268 丢失的数字
//9.	91 解码方法
//10.	138 复制带随机指针的链表
//11.	Offer 10 Ⅱ 青蛙跳台阶问题
//12.	面试题 16.25 LRU缓存   - 完成
//13.	Offer 11 旋转数组的最小数字
//14.	Offer 38 字符串的排列
//15.	27 移除元素          -完成
//16.	71 简化路径          -完成
//17.	181 超过经理收入的员工 -完成
//18.	195 第十行           -完成
//19.	224 基本计算器
//20.	445 两数相加Ⅱ        -完成


fun generate(numRows: Int): List<List<Int>> {

    val result = mutableListOf<List<Int>>()
    for (i in 0 until numRows) {
        val row = mutableListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                row.add(1)
            } else {
                row.add(result[i - 1][j] + result[i - 1][j - 1])
            }
        }
        result.add(row)
    }
    return result

}


fun missingNumber(nums: IntArray): Int {
    return 0
}

fun isBalanced(root: TreeNode?): Boolean {

    if (root == null) {
        return true
    }

    return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)

}

fun height(treeNode: TreeNode?): Int {
    if (treeNode == null) {
        return 0
    }
    return height(treeNode.left).coerceAtLeast(height(treeNode.right)) + 1


}


fun removeElement(nums: IntArray, `val`: Int): Int {

    var len = 0
    for (num in nums) {
        if (num != `val`) {
            nums[len] = num
            len++
        }
    }
    return len

}


fun simplifyPath(path: String): String {
    val list = path.split("/")
    var deque = ArrayDeque<String>()
    for (s in list) {

        if (s == "..") {
            if (!deque.isEmpty()) {
                deque.pollLast()
            }

        } else if (s.isNotBlank() && s != ".") {
            deque.offer(s)
        }

    }
    var result = ""
    while (!deque.isEmpty()) {
        result += "/" + deque.poll()
    }

    return if (result.isBlank()) "/" else result
}


fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {

    var n1 = l1
    var n2 = l2
    var d1 = ArrayDeque<Int>()
    var d2 = ArrayDeque<Int>()
    while (n1 != null) {
        d1.addLast(n1.`val`)
        n1 = n1.next
    }
    while (n2 != null) {
        d2.addLast(n2.`val`)
        n2 = n2.next
    }
    var carry = 0
    var res: ListNode? = null
    while (!d1.isEmpty() || !d2.isEmpty() || carry != 0) {

        var a = if (d1.isEmpty()) 0 else d1.pollLast()
        var b = if (d2.isEmpty()) 0 else d2.pollLast()
        var sum = a + b + carry
        var node = ListNode(sum % 10)
        node.next = res
        res = node
        carry = sum / 10

    }
    return res
}