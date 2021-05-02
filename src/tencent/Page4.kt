package tencent

import bean.ListNode
import bean.TreeNode
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque


//1.    287 寻找重复数  - 完成
//2.	142 环形链表Ⅱ  - 完成
//3.	175 组合2个表   - 完成
//4.	238 除自身以外数组的乘积 - 完成
//5.	39 组合总和  - 完成
//6.	92 反转链表Ⅱ  - 完成
//7.	64 最小路径和  - 完成
//8.	102 二叉树的层序遍历  - 完成
//9.	151 翻转字符串里的单词 - 完成
//10.	16 最接近的三数之和  - 完成
//11.	62 不同路径       - 完成
//12.	61 旋转链表        - 完成
//13.	240 搜索二维矩阵Ⅱ   - 完成
//14.	231 2的幂         - 完成
//15.	56 合并区间        - 完成
//16.	76 最小覆盖子串
//17.	235 二叉搜索树的最近公共祖先  - 完成
//18.	28 实现strStr()
//19.	84 柱状图中的最大矩形  - 完成
//20.	199 二叉树的右视图   - 完成


fun uniquePaths(m: Int, n: Int): Int {
    var dp = IntArray(n)
    Arrays.fill(dp, 1)
    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[j] += dp[j - 1]
        }
    }

    return dp[n - 1]

}
fun largestRectangleArea(heights: IntArray): Int {

    var deque = ArrayDeque<Int>()
    var newH = IntArray(heights.size + 2)
    for (i in 1 until newH.size - 1) {
        newH[i] = heights[i - 1]
    }
    var ans = 0
    for (i in newH.indices) {
        while (!deque.isEmpty() && newH[deque.last()] > newH[i]) {
            var cur = deque.removeLast()
            ans = ans.coerceAtLeast((i - deque.last() - 1) * newH[cur])
        }
        deque.addLast(i)
    }
    return ans

}


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) {
        return head
    }
    var tail = head
    var n = 0
    while (tail?.next != null) {
        n++
        tail = tail.next
    }
    n++
    tail?.next = head
    var h = head
    for (i in 0 until (n - k % n - 1)) {
        h = h?.next
    }
    var ans = h!!.next
    h.next = null
    return ans

}

fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    if (head == null) {
        return null
    }
    var ans = head
    var m1 = m
    var n1 = n
    var p = head
    var q: ListNode? = null
    while (m1 > 1) {
        q = p
        p = p?.next
        m1--
        n1--
    }
    var o = q
    var k = p
    var t: ListNode? = null
    while (n1 > 0) {
        t = p?.next
        p?.next = q
        q = p
        p = t
        n1--
    }
    if (o != null) {
        o.next = q
    } else {
        ans = q
    }
    k?.next = p

    return ans


}

fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return null
    }
    var slow = head
    var fast = head
    do {
        slow = slow?.next
        fast = fast?.next?.next
    } while (fast != slow)
    slow = head
    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }
    return slow
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    var list = mutableListOf<List<Int>>()
    if (root == null) {
        return list
    }
    val arrayDeque = java.util.ArrayDeque<TreeNode>()
    arrayDeque.offer(root)
    while (!arrayDeque.isEmpty()) {
        var size = arrayDeque.size
        var level = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = arrayDeque.poll()
            level.add(node.`val`)
            if (node.left != null) {
                arrayDeque.offer(node.left!!)
            }
            if (node.right != null) {
                arrayDeque.offer(node.right!!)
            }
        }
        list.add(level)
    }
    return list

}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

    var ans = mutableListOf<List<Int>>()
    if (candidates.isEmpty()) {
        return ans
    }
    var path = mutableListOf<Int>()
    dfs2(candidates, target, path, ans, 0)
    return ans

}

fun dfs2(candidates: IntArray, target: Int, path: MutableList<Int>, ans: MutableList<List<Int>>, i: Int) {

    if (target < 0) {
        return
    }
    if (target == 0) {
        ans.add(path.toMutableList())
        return
    }
    for (j in i until candidates.size) {
        path.add(candidates[j])
        dfs2(candidates, target - candidates[j], path, ans, j)
        path.removeAt(path.size - 1)

    }


}

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isNullOrEmpty() || grid[0].isEmpty()) {
        return 0
    }
    var dp = Array(grid.size) {
        IntArray(grid[0].size)
    }
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (i == 0 && j == 0) {
                dp[i][j] = grid[0][0]
            } else if (i > 0 && j == 0) {
                dp[i][j] = grid[i][j] + dp[i - 1][j]
            } else if (i == 0 && j > 0) {
                dp[i][j] = grid[i][j] + dp[i][j - 1]
            } else {
                dp[i][j] = grid[i][j] + dp[i - 1][j].coerceAtMost(dp[i][j - 1])
            }

        }


    }
    return dp[grid.size - 1][grid[0].size - 1]

}

fun productExceptSelf(nums: IntArray): IntArray {

    var ans = IntArray(nums.size)
    var p = 1
    var q = 1
    for (i in nums.indices) {
        ans[i] = p
        p *= nums[i]
    }
    for (i in nums.size - 1 downTo 1) {
        q *= nums[i]
        ans[i - 1] *= q
    }
    return ans
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    var row = matrix.size - 1
    var col = 0
    while (row >= 0 && col < matrix[0].size) {
        when {
            matrix[row][col] > target -> {
                row--
            }
            target > matrix[row][col] -> {
                col++
            }
            else -> {
                return true
            }
        }

    }
    return false

}

fun isPowerOfTwo(n: Int): Boolean {

    if (n == 0) {
        return false
    }
    var x = n.toLong()
    return x and (x - 1) == 0L

}


fun lowestCommonAncestor1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) {
        return root
    }
    var ans = root
    while (true) {
        ans = if (q.`val` < ans!!.`val` && p.`val` < ans.`val`) {
            ans.left!!
        } else if (q.`val` > ans!!.`val` && p.`val` > ans.`val`) {
            ans.right!!
        } else {
            break
        }

    }
    return ans


}


fun findDuplicate(nums: IntArray): Int {

    var slow = 0
    var fast = 0
    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)
    slow = 0
    while (slow != fast) {
        fast = nums[fast]
        slow = nums[slow]
    }

    return slow
}

fun reverseWords(s: String): String {
    var deque = ArrayDeque<String>()
    var l = 0
    var r = s.length - 1
    while (l <= r && s[l] == ' ') {
        l++
    }
    while (l <= r && s[r] == ' ') {
        r--
    }
    var build = StringBuilder()
    while (l <= r) {
        if (build.isNotEmpty() && s[l] == ' ') {
            deque.addFirst(build.toString())
            build.setLength(0)
        } else if (s[l] != ' ') {
            build.append(s[l])
        }
        l++
    }
    if (build.isNotEmpty()) {
        deque.addFirst(build.toString())
    }
    return deque.joinToString(separator = " ")

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {


    if (intervals.isEmpty()) {
        return Array(0) {
            IntArray(2)
        }
    }
    Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }
    var ans = arrayListOf<IntArray>()
    for (interval in intervals) {
        if (ans.isEmpty()) {
            ans.add(interval)
        } else {
            val array = ans[ans.lastIndex]
            if (interval[0] <= array[1]) {
                array[1] = interval[1].coerceAtLeast(array[1])
            } else {
                ans.add(interval)
            }
        }
    }

    return ans.toTypedArray()

}

fun rightSideView(root: TreeNode?): List<Int> {
    var ans = mutableListOf<Int>()
    if (root == null) {
        return ans
    }
    var deque = ArrayDeque<TreeNode>()
    deque.addLast(root)
    while (deque.isNotEmpty()) {
        var size = deque.size
        for (i in 0 until size) {
            var node = deque.removeFirst()
            if (node.left != null) {
                deque.addLast(node.left!!)
            }
            if (node.right != null) {
                deque.addLast(node.right!!)
            }
            if (i == size - 1) {
                ans.add(node.`val`)
            }
        }

    }
    return ans


}

fun threeSumClosest(nums: IntArray, target: Int): Int {

    Arrays.sort(nums)
    var ans = nums[0] + nums[1] + nums[2]
    for (i in nums.indices) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            var sum = nums[i] + nums[j] + nums[k]
            if (Math.abs(sum - target) < Math.abs(target - ans)) {
                ans = sum
            }
            when {
                sum > target -> {
                    k--
                }
                sum < target -> {
                    j++
                }
                else -> {
                    return ans
                }
            }

        }

    }

    return ans

}

