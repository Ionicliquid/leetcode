package bytedance

import bean.ListNode
import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.collections.ArrayDeque


//1. 1. 两数之和                 - 完成
//2. 2. 两数相加                 - 完成
//3. 3. 无重复字符的最长子串
//4. 4. 寻找两个正序数组的中位数
//5. 7. 整数反转                - 完成
//6. 8. 字符串转换整数 (atoi)
//7. 11. 盛最多水的容器             - 完成
//8. 12. 整数转罗马数字
//8. 13. 罗马数字转整数
//10. 14. 最长公共前缀              - 完成
//11. 15. 三数之和                 - 完成
//12. 18. 四数之和
//13. 19. 删除链表的倒数第 N 个结点   - 完成
//14. 20. 有效的括号               - 完成
//15. 21. 合并两个有序链表         - 完成
//16. 23. 合并K个升序链表         - 完成   - 分治法未完成
//17. 24. 两两交换链表中的节点     - 完成
//18. 25. K 个一组翻转链表
//19. 31. 下一个排列           - 完成
//20. 33. 搜索旋转排序数组      - 完成


fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {


    var node = head
    for (i in 0 until n) {
        node = node?.next
    }
    var dump = ListNode(0)
    dump.next = head
    var ans = dump
    while (node != null) {
        node = node.next
        dump = dump.next!!
    }
    dump.next = dump.next?.next
    Executors.newCachedThreadPool()

    return ans.next

}


fun swapPairs(head: ListNode?): ListNode? {
    var dump = ListNode(0)
    dump.next = head
    var temp = dump
    while (temp.next != null && temp.next!!.next != null) {

        val n1 = temp.next
        val n2 = temp.next!!.next
        n1!!.next = n2!!.next
        n2.next = n1
        temp.next = n2
        temp = n1
    }
    return dump.next
}


fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

    var n1 = head
    var dump: ListNode? = ListNode(0)
    dump!!.next = head
    var pre = dump
    while (n1 != null) {
        var temp = pre
        for (i in 0 until k) {
            temp = temp?.next

        }
        var next = temp!!.next


    }

    return null

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {

    var queue = PriorityQueue<ListNode> { o1, o2 -> o1.`val` - o2.`val` }
    for (list in lists) {
        if (list != null) {
            queue.offer(list)
        }

    }
    var dump = ListNode(0)
    val ans = dump
    while (!queue.isEmpty()) {
        val node = queue.poll()
        dump.next = ListNode(node.`val`)
        dump = dump.next!!
        if (node.next != null) queue.offer(node.next)

    }

    return ans.next

}


fun myAtoi(s: String): Int {

    var l = 0
    while (l < s.length && s[l] == ' ') {
        l++
    }
    var a = 1
    if (s[l] == '-') {
        a = -1
    } else {

    }
    var ans = 1

    return 0


}


//  36241
fun nextPermutation(nums: IntArray): Unit {
    var i = nums.size - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }
    if (i >= 0) {
        var j = nums.size - 1
        while (j > i) {
            if (nums[j] > nums[i]) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                break
            }
            j--
        }
    }
    var l = i + 1
    var r = nums.size - 1
    while (l < r) {
        var temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp
        l++
        r--
    }
}

fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (nums[mid] >= nums[l]) {
            if (target >= nums[l] && target <= nums[mid]) {
                r = mid - 1
            } else {
                l = mid + 1
            }


        } else {
            if (target >= nums[mid] && target <= nums[r]) {
                l = mid + 1
            } else {
                r = mid - 1
            }

        }

    }

    return -1


}

fun reverse(x: Int): Int {

    var y = x
    var ans = 0
    while (y != 0) {
        val m = y % 10
        if ((ans == Int.MAX_VALUE / 10 && m > 7) || (ans == Int.MIN_VALUE / 10 && m < -8)
            || ans > Int.MAX_VALUE / 10 || ans < Int.MIN_VALUE / 10
        ) return 0
        ans = ans * 10 + m

        y /= 10
    }
    return ans


}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val value = target - nums[i]
        if (map.containsKey(value)) {
            return intArrayOf(i, map[value]!!)
        } else {
            map[nums[i]] = i
        }
    }
    return IntArray(2)

}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var dummpy = ListNode(0)
    val ans = dummpy
    var n1 = l1
    var n2 = l2
    var r = 0
    while (n1 != null || n2 != null) {

        val a = n1?.`val` ?: 0
        val b = n2?.`val` ?: 0
        n1 = n1?.next
        n2 = n2?.next
        val sum = a + b + r
        r = sum % 10
        dummpy.next = ListNode(sum / 10)
        dummpy = dummpy.next!!

    }
    if (r != 0) {
        dummpy.next = ListNode(r)
    }
    return ans.next


}


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var n1 = l1
    var n2 = l2
    var dummpy = ListNode(0)
    val ans = dummpy
    while (n1 != null && n2 != null) {

        var value = 0
        if (n1.`val` > n2.`val`) {
            value = n2.`val`
            n2 = n2.next

        } else {
            value = n1.`val`
            n1 = n1.next
        }
        dummpy.next = ListNode(value)
        dummpy = dummpy.next!!
    }
    dummpy.next = n1 ?: n2

    return ans.next
}


fun maxArea(height: IntArray): Int {

    var left = 0
    var right = height.size - 1
    var ans = 0
    while (left < right) {

        val max = (right - left) * (height[left].coerceAtMost(height[right]))
        ans = ans.coerceAtLeast(max)
        if (height[left] > height[right]) {
            right--
        } else {
            left++
        }

    }
    return ans

}

fun lengthOfLongestSubstring(s: String): Int {
    var set = mutableSetOf<Char>()
    var ans = 0
    var res = -1
    for (i in s.indices) {

        if (i > 0) {
        }
        ans = ans.coerceAtLeast(res - i + 1)
    }
    return ans

}

fun longestCommonPrefix(strs: Array<String>): String {

    if (strs.isEmpty()) {
        return ""
    }
    var ans = strs[0]
    for (i in ans.indices) {

        for (j in 1 until strs.size) {

            if (i == strs[j].length || ans[i] != strs[j][i]) {
                return ans.substring(0, i)
            }


        }


    }

    return ans


}


fun threeSum(nums: IntArray): List<List<Int>> {

    var ans = arrayListOf<List<Int>>()
    if (nums.size < 3) {
        return ans
    }
    Arrays.sort(nums)
    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            break
        }
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            when {
                sum > 0 -> r--
                sum < 0 -> l++
                sum == 0 -> {
                    val list = listOf(nums[i], nums[l], nums[r])
                    ans.add(list)
                    while (r > l + 1 && nums[l + 1] == nums[l]) {
                        l++
                    }
                    while (r - 1 > l && nums[r - 1] == nums[r]) {
                        r--
                    }
                    l++
                    r--
                }
            }
        }
    }
    return ans

}


fun isValid(s: String): Boolean {

    val map = mapOf(']' to "[", '}' to '{', ')' to '(')
    val queue = ArrayDeque<Char>()

    for (c in s) {

        if (map.containsKey(c)) {

            if (!queue.isEmpty() && queue.removeLast() == map[c]) {
                continue
            } else {
                return false
            }


        } else {
            queue.addLast(c)
        }

    }
    return queue.isEmpty()

}

