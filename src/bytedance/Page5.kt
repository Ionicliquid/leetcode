package bytedance

import bean.ListNode
import bean.TreeNode
import java.util.*


//1. 206. 反转链表                   - 完成
//2. 215. 数组中的第K个最大元素         - 完成
//3. 230. 二叉搜索树中第K小的元素
//4. 232. 用栈实现队列              - 完成
//5. 234. 回文链表
//6. 235. 二叉搜索树的最近公共祖先        - 完成
//7. 236. 二叉树的最近公共祖先        - 完成
//8. 260. 只出现一次的数字 III       - 完成
//9. 268. 丢失的数字
//10. 297. 二叉树的序列化与反序列化
//11. 315. 计算右侧小于当前元素的个数
//12. 322. 零钱兑换                  - 完成
//13. 329. 矩阵中的最长递增路径
//14. 343. 整数拆分
//15. 347. 前 K 个高频元素
//16. 365. 水壶问题
//17. 386. 字典序排数
//18. 387. 字符串中的第一个唯一字符
//19. 403. 青蛙过河
//20. 410. 分割数组的最大值


fun singleNumber(nums: IntArray): IntArray {

    var ret = 0
    for (num in nums) {
        ret = ret xor num
    }
    var div = 1
    while ((div and ret)!=0){
        div = div shl  1
    }
    var a = 0
    var b = 0
    for (num in nums) {
        if((num and  div) ==0){
            a  = a xor  num
        }else{
            b = b xor num
        }

    }
    return intArrayOf(a ,b)


}


fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var node = reverseList(head.next)
    head?.next?.next = head
    head.next = null
    return node

}


fun reverseList1(head: ListNode?): ListNode? {

    var pre: ListNode? = null
    var cur = head
    while (cur != null) {
        val node = cur.next
        cur.next = pre
        pre = cur
        cur = node


    }
    return pre
}


fun findKthLargest(nums: IntArray, k: Int): Int {

    var size = nums.size

    buildMaxHeap(nums, size)
    for (i in nums.size - 1 downTo nums.size - k + 1) {
        swap(0, size - 1, nums)
        size--
        maxHeap(0, size, nums)
    }

    return nums[0]


}

fun buildMaxHeap(nums: IntArray, size: Int) {

    for (i in size / 2 downTo 0) {

        maxHeap(i, size, nums)


    }
}

fun maxHeap(i: Int, size: Int, nums: IntArray) {
    var l = i * 2
    var r = i * 2 + 1
    var largest = i
    if (l < size && nums[l] > nums[largest]) {
        largest = l
    }

    if (r < size && nums[r] > nums[largest]) {
        largest = r
    }
    if (largest != i) {

        swap(i, largest, nums)
        maxHeap(largest, size, nums)
    }


}

fun swap(i: Int, largest: Int, nums: IntArray) {
    var temp = nums[i]
    nums[i] = nums[largest]
    nums[largest] = temp
}


fun coinChange(coins: IntArray, amount: Int): Int {

    var dp = IntArray(amount + 1)
    Arrays.fill(dp, amount + 1)
    dp[0] = 0
    for (i in 1 until dp.size) {
        for (coin in coins) {
            if (i >= coin) {
                dp[i] = dp[i].coerceAtMost(dp[i - coin] + 1)
            }
        }

    }
    return if (dp[amount] > amount) -1 else dp[amount]


}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

    if (root == null) {
        return root
    }
   var x =  root.let {
        1
    }


    if (p!!.`val` < root!!.`val` && q!!.`val` < root!!.`val`) {
        return lowestCommonAncestor(root.left, p, q)
    }

    if (p!!.`val` > root!!.`val` && q!!.`val` > root!!.`val`) {
        return lowestCommonAncestor(root.right, p, q)
    }

    return root


}

fun lowestCommonAncestor1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

    if (root == null || root == p || root == q) {
        return root
    }
    val left = lowestCommonAncestor1(root.left, p, q)
    var right = lowestCommonAncestor1(root.right, p, q)
    if (left == null) {
        return right
    }
    if (right == null) {
        return left
    }
    return root
}
