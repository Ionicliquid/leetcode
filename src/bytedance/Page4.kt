package bytedance

import bean.ListNode
import bean.TreeNode


//1. 129. 求根到叶子节点数字之和
//2. 135. 分发糖果
//3. 141. 环形链表        - 完成
//4. 142. 环形链表 II     - 完成
//5. 143. 重排链表
//6. 144. 二叉树的前序遍历   - 完成
//7. 146. LRU 缓存机制
//8. 148. 排序链表
//9. 160. 相交链表     - 完成
//10. 167. 两数之和 II - 输入有序数组
//11. 176. 第二高的薪水    - 完成
//12. 177. 第N高的薪水    - 完成
//13. 179. 最大数
//14. 180. 连续出现的数字
//15. 184. 部门工资最高的员工   - 完成
//16. 185. 部门工资前三高的所有员工  - 完成
//17. 191. 位1的个数
//18. 192. 统计词频        - 完成
//19. 199. 二叉树的右视图   - 完成
//20. 200. 岛屿数量   - 完成


fun rightSideView(root: TreeNode?): List<Int> {
    var ans = mutableListOf<Int>()
    if (root == null) {
        return ans
    }
    var queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    while (!queue.isEmpty()) {

        val size = queue.size
        for (i in 0 until size) {

            val node = queue.removeFirst()
            if (node.left != null) {
                queue.addLast(node.left!!)
            }
            if (node.right != null) {
                queue.addLast(node.right!!)
            }
            if(i==size-1){
                ans.add(node.`val`)
            }
        }
    }
    return ans

}


fun hasCycle(head: ListNode?): Boolean {

    if (head?.next == null) return false
    var fast = head.next
    var slow = head
    while (slow != null && fast != null) {
        if (slow == fast) {
            return true
        }
        slow = slow.next
        fast = fast.next?.next

    }
    return false

}

fun detectCycle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    do {
        slow = slow?.next
        fast = fast?.next?.next
    } while (slow != fast)
    var first = head
    while (first != slow) {
        slow = slow?.next
        first = first?.next

    }
    return slow
}


fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var a = headA
    var b = headB
    while (a != b) {
        a = if (a != null) {
            a.next
        } else {
            headB
        }

        b = if (b != null) {
            b.next
        } else {
            headA
        }


    }
    return a


}


//  root  left  right
fun preorderTraversal(root: TreeNode?): List<Int> {
    val ans = mutableListOf<Int>()
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
                ans.add(cur.`val`)
                cur = cur.left

            } else {

                pre.right = null
                cur = cur.right

            }
        }

    }


    return ans


}


fun numIslands(grid: Array<CharArray>): Int {

    var count = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {

            if (grid[i][j] == '1') {
                dfs(grid, i, j)
                count++
            }
        }
    }
    return count
}

fun dfs(grid: Array<CharArray>, i: Int, j: Int) {

    if (i < grid.size && i >= 0 && j >= 0 && j < grid[0].size && grid[i][j] == '1') {
        grid[i][j] = '0'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j + 1)
        dfs(grid, i, j - 1)
    }


}
