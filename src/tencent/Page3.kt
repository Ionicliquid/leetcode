package tencent

import bean.ListNode
import bean.TreeNode
import java.util.*
import kotlin.collections.ArrayDeque

//1.    89 格雷编码  - 完成
//2.	Offer 09 用2个栈实现队列  - 完成
//3.	10 正则表达式匹配   - 完成
//4.	59 螺旋矩阵Ⅱ   - 完成
//5.	105 从前序与中序遍历序列构造二叉树  - 完成
//6.	124 二叉树中的最大路径和  - 完成
//7.	236 二叉树的最近公共祖先  - 完成
//8.	322 零钱兑换    - 完成
//9.	160 相交链表    - 完成
//10.	50 Pow(x,y)    - 完成
//11.	78 子集        - 完成
//12.	200 岛屿数量     - 完成
//13.	230 二叉搜索树中的第K小元素  - 完成
//14.	347 前K个高频元素  - 完成
//15.	14 最长公共前缀   - 完成
//16.	144 二叉树的前序遍历 - 完成
//17.	155 最小栈   - 完成
//18.	415 字符串相加 - 完成
//19.	22 括号生成    - 完成
//20.	6 Z 字形变换  - 完成


fun grayCode(n: Int): List<Int> {
    var ans = arrayListOf<Int>()
    ans.add(0)
    var head = 1
    for (i in 0 until n) {

        for (j in ans.size - 1 downTo 0) {

            ans.add(head + ans[j])


        }
        head = head shl 1


    }
    return ans


}


fun kthSmallest(root: TreeNode?, k: Int): Int {

    var deque = ArrayDeque<TreeNode>()

    var k1 = k
    var tree = root
    while (true) {


        while (tree != null) {

            deque.addLast(tree)
            tree = tree.left

        }
        tree = deque.removeLast()
        if (--k1 == 0) return tree.`val`
        tree = tree.right

    }


}

fun isMatch(s: String, p: String): Boolean {

    var m = s.length
    var n = p.length
    var dp = Array(m + 1) {
        BooleanArray(n + 1)
    }
    dp[0][0] = true
    for (i in 0..m) {
        for (j in 1..n) {

            if (j > 1 && p[j - 1] == '*') {

                dp[i][j] = dp[i][j - 2]
                if (match(s, p, i, j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j]
                }

            } else {

                if (match(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1]
                }

            }

        }
    }
    return dp[m][n]


}

fun match(s: String, p: String, i: Int, j: Int): Boolean {

    if (i == 0) {
        return false
    }
    if (p[j - 1] == '.') {
        return true
    }
    return s[i - 1] == p[j - 1]

}


fun topKFrequent(nums: IntArray, k: Int): IntArray {

    var map = mutableMapOf<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    var queue = PriorityQueue<Int> { o1, o2 -> map[o2]!! - map[o1]!! }
    for (entry in map) {
        queue.offer(entry.key)
    }
    var k1 = k
    var ans = arrayListOf<Int>()
    while (k1 > 0) {
        ans.add(queue.poll())


        k1--


    }
    return ans.toIntArray()

}


fun generateMatrix(n: Int): Array<IntArray> {


    var r1 = 0
    var r2 = n - 1
    var c1 = 0
    var c2 = n - 1
    var ans = Array(n) {
        IntArray(n)
    }
    var num = 1
    while (r2 >= r1 && c2 >= c1) {

        for (i in c1..c2) {
            ans[r1][i] = num++
        }
        for (i in r1 + 1..r2) {
            ans[i][c2] = num++
        }

        if (r2 > r1 && c2 > c1) {
            for (i in c2 - 1 downTo c1) {
                ans[r2][i] = num++
            }

            for (i in r2 - 1 downTo r1 + 1) {
                ans[i][c1] = num++
            }
        }
        r1++
        c1++
        r2--
        c2--


    }

    return ans


}


fun coinChange(coins: IntArray, amount: Int): Int {

    val dp = IntArray(amount + 1)
    Arrays.fill(dp, amount + 1)
    dp[0] = 0
    for (i in 1 until dp.size) {
        for (j in coins.indices) {

            if (coins[j] <= i) {

                dp[i] = dp[i].coerceAtMost(dp[i - coins[j]] + 1)
            }


        }


    }

    return if (dp[amount] > amount) -1 else dp[amount]

}

var ans = Int.MIN_VALUE
fun maxPathSum(root: TreeNode?): Int {

    dfs5(root)
    return ans
}

fun dfs5(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var left = 0.coerceAtLeast(dfs5(root.left))
    var right = 0.coerceAtLeast(dfs5(root.right))

    ans = ans.coerceAtLeast(left + right + root.`val`)

    return root.`val` + left.coerceAtLeast(right)
}


fun myPow(x: Double, n: Int): Double {
    if (x == 0.toDouble()) {
        return x
    }
    var n1 = n.toLong()
    var x1 = x
    if (n1 < 0) {
        n1 = -n1
        x1 = 1 / x1
    }
    var ans = 0.toDouble()
    while (n1 > 0) {
        if (n1 and 1 == 1.toLong()) {
            ans *= x
        }
        x1 *= x1

        n1 /= 2

    }
    return ans

}


fun numIslands(grid: Array<CharArray>): Int {

    var count = 0

    for (i in grid.indices) {

        for (j in grid[0].indices) {

            if (grid[i][j] == '1') {
                dfs4(grid, i, j)
                count++
            }


        }

    }

    return count

}

fun dfs4(grid: Array<CharArray>, i: Int, j: Int) {

    if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == '0') {
        return
    }
    grid[i][j] = '0'

    dfs4(grid, i + 1, j)
    dfs4(grid, i - 1, j)
    dfs4(grid, i, j + 1)
    dfs4(grid, i, j - 1)

}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

    if (preorder.isEmpty() || inorder.isEmpty()) {
        return null
    }
    var root = TreeNode(preorder[0])
    var deque = ArrayDeque<TreeNode>()
    deque.addLast(root)
    var inOrderIndex = 0
    for (i in 1 until preorder.size) {
        var preorderVal = preorder[i]
        var node = deque.last()
        if (node.`val` != inorder[inOrderIndex]) {
            node.left = TreeNode(preorderVal)
            deque.addLast(node.left!!)
        } else {
            while (!deque.isEmpty() && deque.last().`val` == inorder[inOrderIndex]) {
                node = deque.removeLast()
                inOrderIndex++
            }
            node.right = TreeNode(preorderVal)
            deque.addLast(node.right!!)
        }

    }

    return root

}


fun generateParenthesis(n: Int): List<String> {

    var result = mutableListOf<String>()

    dfs3(result, 0, 0, n, StringBuilder())

    return result

}

fun dfs3(result: MutableList<String>, left: Int, right: Int, n: Int, path: StringBuilder) {
    if (path.length == 2 * n) {
        result.add(path.toString())
        return
    }
    if (left < n) {
        path.append("(")
        dfs3(result, left + 1, right, n, path)
        path.delete(path.length - 1, path.length)

    }
    if (right < left) {
        path.append(")")
        dfs3(result, left, right + 1, n, path)
        path.delete(path.length - 1, path.length)
    }
}

fun convert(s: String, numRows: Int): String {

    if (numRows == 1) {
        return s
    }

    var buildList = mutableListOf<StringBuilder>()
    for (i in 0 until numRows) {
        buildList.add(StringBuilder())

    }
    var curRow = 0
    var goingDown = false
    for (i in s.indices) {
        buildList[curRow].append(s[i])
        if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown
        curRow = if (goingDown) curRow + 1 else curRow - 1


    }
    var builder = StringBuilder()
    for (stringBuilder in buildList) {
        builder.append(stringBuilder)
    }
    return builder.toString()


}


fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var a = headA
    var b = headB
    while (a != b) {
        a = if (a == null) {
            headB
        } else {
            a.next
        }
        b = if (b == null) {
            headA
        } else {
            b.next
        }


    }
    return a
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == root || q == root) {
        return root
    }
    var left = lowestCommonAncestor(root.left, p, q)
    var right = lowestCommonAncestor(root.right, p, q)
    if (left == null && right == null) return null
    if (left == null) return right
    if (right == null) return left
    return root
}


fun subsets(nums: IntArray): List<List<Int>> {

    var ans = mutableListOf<List<Int>>()
    var path = mutableListOf<Int>()
    dfs1(ans, path, 0, nums)
    return ans

}

fun dfs1(ans: MutableList<List<Int>>, path: MutableList<Int>, index: Int, nums: IntArray) {
    ans.add(path.toMutableList())
    for (i in index until nums.size) {
        path.add(nums[i])
        dfs1(ans, path, i + 1, nums)
        path.removeAt(path.size - 1)

    }
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var one = strs[0]
    for (i in one.indices) {
        for (j in 1 until strs.size) {
            if (i == strs[j].length || one[i] != strs[j][i]) {
                return one.substring(0, i)
            }

        }

    }
    return ""


}

fun addStrings(num1: String, num2: String): String {
    var i = num1.length - 1
    var j = num2.length - 1
    var ret = 0
    val build = StringBuilder()
    while (i >= 0 || j >= 0) {
        val a = if (i >= 0) num1[i] - '0' else 0
        val b = if (j >= 0) num2[j] - '0' else 0
        var sum = a + b + ret
        ret = sum / 10
        build.append(sum % 10)
        i--
        j--
    }
    if (ret > 0) {
        build.append(ret)
    }
    return build.reverse().toString()
}


fun preorderTraversal(root: TreeNode?): List<Int> {
    val ans = mutableListOf<Int>()
    if (root == null) {
        return ans
    }
    var curr = root
    while (curr != null) {

        if (curr.left == null) {
            ans.add(curr.`val`)
            curr = curr.right
        } else {
            var pre = curr.left
            while (pre?.right != null && pre.right != curr) {
                pre = pre.right
            }
            if (pre?.right == null) {
                pre?.right = curr
                ans.add(curr.`val`)
                curr = curr.left
            } else {
                pre.right = null
                curr = curr.right
            }

        }


    }
    return ans

}




