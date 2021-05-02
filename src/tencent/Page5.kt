package tencent

import bean.ListNode
import bean.TreeNode


//1.   470 用Rand7()实现Rand10()  - 完成
//2.	Offer24-反转链表     - 完成
//3.	69 x的平方根         - 完成
//4.	83 删除链表中的重复元素   - 完成
//5.	94 二叉树的中序遍历  - 完成
//6.	176  第二高的薪水   - 完成
//7.	185 部门工资前三的高的所有员工 - 完成
//8.	198 打家劫舍  - 完成
//9.	48 旋转图像   - 完成
//10.	384 打乱数组
//11.	494 目标和
//12.	31 下一个排列  - 完成
//13.	204 计数质数
//14.	35 搜索插入位置   - 完成
//15.	63 不同路径Ⅱ
//16.	112 路径总和   - 完成
//17.	222 完全二叉树的节点个数
//18.	225 用队列实现栈   - 完成
//19.	217 存在重复元素  - 完成
//20.	152 乘积最大子数组  - 完成







fun countNodes(root: TreeNode?): Int {
    return 0
}


fun mySqrt(x: Int): Int {
    var l = 0
    var r = x
    var ans = -1
    while (l <= r) {
        val mid = (l + r) / 2
        var m = (mid * mid).toLong()
        if (m <= x) {
            ans = mid
            l = mid + 1
        } else {
            r = mid - 1
        }

    }
    return ans

}


fun nextPermutation(nums: IntArray): Unit {
    var i = nums.size - 2
    while (i >= 0 && nums[i] > nums[i + 1]) {
        i--
    }
    if (i >= 0) {
        var j = nums.size - 1
        while (j >= 0 && nums[i] >= nums[j]) {
            j--
        }
        swap(nums, i, j)
    }
    reverse(nums, i + 1)

}

fun reverse(nums: IntArray, i: Int) {
    var left = i
    var right = nums.size - 1
    while (left < right) {
        swap(nums, left, right)
        left++
        right--
    }


}

fun swap(nums: IntArray, i: Int, j: Int) {

    var temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

}


fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }
    if (root.left == null && root.right == null) {
        return targetSum == root.`val`
    }
    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)

}


fun searchInsert(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            nums[mid] == target -> {
                return mid
            }
            nums[mid] > target -> {
                right = mid - 1
            }
            else -> {
                left = mid + 1
            }
        }

    }
    return left

}

fun findTargetSumWays(nums: IntArray, S: Int): Int {
        return 0
}

fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var min = nums[0]
    var max = nums[0]
    var ans = nums[0]
    for (i in 1 until nums.size) {
        val maxF = max
        val minF = min
        max = nums[i].coerceAtLeast(nums[i] * maxF).coerceAtLeast((nums[i] * minF))
        min = nums[i].coerceAtMost(nums[i] * minF).coerceAtMost(nums[i] * maxF)
        ans = max.coerceAtLeast(ans)

    }
    return ans

}


fun reverseList2(head: ListNode?): ListNode? {

    if (head?.next == null) {
        return head
    }
    var node = reverseList2(head.next)
    head.next?.next = head
    head.next = null
    return node

}

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    if (nums.size == 1) {
        return nums[0]
    }
    var f = nums[0]
    var s = nums[0].coerceAtLeast(nums[2])
    var ans = 0
    for (i in 2 until nums.size) {
        ans = (nums[i] + f).coerceAtLeast(s)
        f = s
        s = ans
    }
    return ans

}


fun rotate(matrix: Array<IntArray>): Unit {

    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return
    }
    var n = matrix.size
    for (i in 0 until n) {
        for (j in i until n) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }

    }
    for (i in 0 until n) {
        var l = 0
        var r = n - 1
        while (r > l) {

            var temp = matrix[i][r]
            matrix[i][r] = matrix[i][l]
            matrix[i][l] = temp
            r--
            l++
        }

    }


}


fun reverseList3(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var node = head
    var pre: ListNode? = null
    while (node != null) {
        var n = node.next
        node.next = pre
        pre = node
        node = n
    }
    return pre

}

fun deleteDuplicates(head: ListNode?): ListNode? {

    var node = head
    while (node?.next != null) {

        if (node.`val` == node.next!!.`val`) {
            node.next = node.next!!.next
        } else {
            node = node.next
        }
    }
    return head

}

fun containsDuplicate(nums: IntArray): Boolean {
    var set = mutableSetOf<Int>()
    for (num in nums) {
        if (set.contains(num)) {
            return true
        }
        set.add(num)
    }
    return false
}

fun inorderTraversal(root: TreeNode?): List<Int> {

    var ans = mutableListOf<Int>()

    if (root == null) {
        return ans
    }

    var cur = root
    while (cur != null) {

        if (cur.left == null) {
            ans.add(cur.`val`)
            cur = cur.right
        } else {
            var pre = cur.left
            while (pre?.right != null && pre.right != cur) {
                pre = pre.right
            }
            if (pre?.right == null) {
                pre?.right = cur
                cur = cur.left
            } else {
                ans.add(cur.`val`)
                pre.right = null
                cur = cur.right
            }
        }


    }


    return ans


}

fun rand7(): Int {
    return 0
}

fun rand10(): Int {
    var x = 0

    do {
        var a = rand7()
        var b = rand7()

        x = a + (b - 1) * 7


    } while (x > 40)
    return 1 + (x - 1) % 10

}