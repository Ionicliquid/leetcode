package tencent

import bean.ListNode
import bean.TreeNode
import java.util.*


//1.    11.盛水最多的容器              - 完成
//2.	136.只出现一次的数字           - 完成
//3.	72.编辑距离                   - 完成
//4.	43.字符串相乘                 - 完成
//5.	26 删除排序数组的重复项         - 完成
//6.	344.反转字符串                - 完成
//7.	23.合并K个有序链表             - 完成
//8.	46.全排列                    - 完成
//9.	54.螺旋矩阵                  - 完成
//10.	42.接雨水                    - 完成
//11.	148.排序链表
//12.	887.鸡蛋掉落
//13.	121.买卖股票的最佳时机  - 完成
//14.	292 Nim游戏           - 完成
//15.	88.合并2个有序数组     -完成
//16.	104 二叉树的最大深度  - 完成
//17.	19 删除链表的倒数第N个节点 -完成
//18.	25 k个一组翻转链表
//19.	237 删除链表中的节点  -完成
//20.	300.最长递增子序列


fun lengthOfLIS(nums: IntArray): Int {

    var dp = IntArray(nums.size)
    dp[0] = 1
    var ans = 1
    for (i in 1 until nums.size) {
        dp[i] = 1
        for (j in 0 until i) {

            if (nums[i] > nums[j]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }

        }
        ans = ans.coerceAtLeast(dp[i])
    }
    return ans
}


fun maxArea(height: IntArray): Int {
    var max = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        var ans = (right - left) * height[left].coerceAtMost(height[right])
        max = max.coerceAtLeast(ans)
        if (height[right] > height[left]) {
            left++
        } else {
            right--
        }
    }
    return max
}

fun removeDuplicates(nums: IntArray): Int {
    var ans = 0
    for (i in nums.indices) {
        if (i == 0) {
            ans++
        } else if (nums[i] != nums[i - 1]) {
            nums[ans] = nums[i]
            ans++
        }
    }
    return ans
}


fun singleNumber(nums: IntArray): Int {
    var r = 0
    for (num in nums) {
        r = num xor r
    }
    return r
}


fun maxProfit(prices: IntArray): Int {

    var max = 0
    var minPrice = Int.MAX_VALUE
    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else if (price - minPrice > max) {
            max = price - minPrice
        }
    }
    return max

}

fun canWinNim(n: Int): Boolean {
    return n % 4 != 0
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var queue = PriorityQueue(Comparator<ListNode> { o1, o2 -> o1.`val` - o2.`val` })
    for (list in lists) {
        if (list != null) {
            queue.offer(list)
        }
    }
    var ans = ListNode(-1)
    var dummy = ans
    while (!queue.isEmpty()) {
        var node = queue.poll()
        if (node.next != null) {
            queue.offer(node.next)
        }
        dummy.next = node
        dummy = dummy.next!!

    }
    return ans.next
}


fun maxDepth(root: TreeNode?): Int {

    if (root == null) {
        return 0
    }
    return maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1

}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var n1 = m - 1
    var n2 = n - 1
    var sum = m + n - 1
    while (n1 >= 0 && n2 >= 0) {

        if (nums1[n1] > nums2[n2]) {
            nums1[sum] = nums1[n1]
            n1--
        } else {
            nums1[sum] = nums2[n2]
            n2--
        }
        sum--
    }
    while (n1 >= 0) {
        nums1[sum] = nums1[n1]
        n1--
        sum--
    }
    while (n2 >= 0) {
        nums1[sum] = nums2[n2]
        n2--
        sum--
    }
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

    var node = head
    for (i in 0 until n) {
        node = node?.next
    }
    var dummy = ListNode(-1)
    dummy.next = head
    var ans = dummy
    var delete = head
    println(node?.`val`)
    while (node != null) {
        dummy = dummy.next!!
        delete = delete?.next
        node = node.next

    }
    println(delete?.`val`)
    dummy.next = delete?.next
    return ans.next

}

fun trap(height: IntArray): Int {

    var l = 0
    var r = height.size - 1
    var lm = 0
    var rm = 0
    var ans = 0
    while (l <= r) {
        if (rm > lm) {
            lm = lm.coerceAtLeast(height[l])
            ans += lm - height[l++]
        } else {
            rm = rm.coerceAtLeast(height[r])
            ans += rm - height[r--]
        }

    }
    return ans

}

fun deleteNode(node: ListNode) {
    node.`val` = node.next!!.`val`
    node.next = node.next!!.next
}

fun reverseString(s: CharArray): Unit {
    var l = 0
    var r = s.size - 1
    while (l < r) {
        var c = s[l]
        s[l] = s[r]
        s[r] = c
        l++
        r--
    }
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var ans = mutableListOf<Int>()
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return ans
    }
    var m = matrix.size - 1
    var n = matrix[0].size - 1
    var m1 = 0
    var n1 = 0
    while (m >= m1 && n >= n1) {
        for (i in n1..n) {
            ans.add(matrix[m1][i])
        }
        for (i in (m1 + 1)..m) {
            ans.add(matrix[i][n])
        }
        if (m > m1 && n > n1) {
            for (i in (n - 1) downTo n1) {
                ans.add(matrix[m][i])
            }
            for (i in (m - 1) downTo m1 + 1) {
                ans.add(matrix[i][m1])
            }
        }

        m1++
        n1++
        m--
        n--

    }
    return ans
}


fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }
    var m = num1.length
    var n = num2.length
    var ansArray = IntArray(m + n)
    for (i in m - 1 downTo 0) {
        var x = num1[i] - '0'
        for (j in n - 1 downTo 0) {
            var y = num2[j] - '0'
            var sum = x * y + ansArray[i + j + 1]
            ansArray[i + j + 1] = sum % 10
            ansArray[i + j] += sum / 10
        }
    }
    var ans = ""
    for (i in ansArray.indices) {
        if (i == 0 && ansArray[i] == 0) continue
        ans += ansArray[i]

    }
    return ans
}

fun minDistance(word1: String, word2: String): Int {
    var m = word1.length
    var n = word2.length
    if (m * n == 0) {
        return m + n
    }
    var dp = Array(m + 1) {
        IntArray(n + 1)
    }
    for (i in 1..m) {
        dp[i][0] = i
    }
    for (i in 1..n) {
        dp[0][i] = i
    }
    for (i in 1..m) {

        for (j in 1..n) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = dp[i - 1][j].coerceAtMost(dp[i - 1][j - 1].coerceAtMost(dp[i][j - 1])) + 1
            }
        }


    }
    return dp[m][n]
}


fun permute(nums: IntArray): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()
    var visited = BooleanArray(nums.size)
    dfs(ans, mutableListOf<Int>(), nums, visited)
    return ans
}


fun dfs(ans: MutableList<List<Int>>, out: MutableList<Int>, nums: IntArray, visited: BooleanArray) {

    if (out.size == nums.size) {
        ans.add(out.toMutableList())
        return
    }
    for (i in nums.indices) {
        if (visited[i]) continue
        visited[i] = true
        out.add(nums[i])
        dfs(ans, out, nums, visited)
        visited[i] = false
        out.removeAt(out.size - 1)
    }

}


fun sortList(head: ListNode?): ListNode? {
    if (head == null) {
        return head
    }
    var n = 0
    var node = head
    while (node != null) {
        n++
        node = node.next
    }
    return null
}




