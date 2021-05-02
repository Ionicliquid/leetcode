package tencent

import bean.ListNode


import java.util.*


//1.    1两数之和              -完成
//2.	206反转来链表           -完成
//3.	5 最长回文串              -完成
//4.	3. 无重复字符的最长子串      -完成
//5.	2 两数相加                -完成
//6.	4 寻找2个正序数组的中位数   - 完成
//7.	21 合并2个有序链表         -完成
//8.	70 爬楼梯                - 完成
//9.	53 最大子序和            - 完成
//10.	15 三数之和               - 完成
//11.	141 环形链表              - 完成
//12.	146 LRU缓存机制           - 完成
//13.	394 字符串解码             - 完成
//14.	20 有效的括号              -完成
//15.	8 字符串转整数             - 完成
//16.	215 数组中的第K的最大元素    - 完成
//17.	9 回文数                   - 完成
//18.	7 整数反转                  - 完成
//19.	33 搜索旋转排序数组        - 完成
//20.	169 多数元素             - 完成


fun maxSubArray(nums: IntArray): Int {
    var pre = 0
    var maxAns = nums[0]
    for (num in nums) {

        pre = (pre + num).coerceAtLeast(num)

        maxAns = maxAns.coerceAtLeast(pre)


    }

    return maxAns

}


fun findKthLargest(nums: IntArray, k: Int): Int {

    var size = nums.size
    buildHeap(nums, size)
    for (i in nums.size - 1 downTo nums.size - k - 1) {
        swap1(0, i, nums)
        size--
        maxHeap(nums, 0, size)
    }
    return nums[0]


}

fun buildHeap(nums: IntArray, size: Int) {

    for (i in size / 2 downTo 0) {
        maxHeap(nums, i, size)
    }

}

fun maxHeap(nums: IntArray, i: Int, size: Int) {
    var l = 2 * i
    var r = 2 * i + 1
    var largest = i
    if (l < size && nums[l] > nums[largest]) {
        largest = l
    }
    if (r < size && nums[r] > nums[largest]) {
        largest = r
    }
    if (largest != i) {
        swap1(i, largest, nums)
        maxHeap(nums, largest, size)
    }


}

fun swap1(i: Int, largest: Int, nums: IntArray) {
    val temp = nums[i]
    nums[i] = nums[largest]
    nums[largest] = temp

}


fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    var total = nums1.size + nums2.size
    return if (total % 2 == 0) {

        (getK(nums1, nums2, total / 2) + getK(nums1, nums2, total / 2 + 1)) / 2.toDouble()

    } else {

        getK(nums1, nums2, total / 2 + 1).toDouble()

    }

}

fun getK(nums1: IntArray, nums2: IntArray, k1: Int): Int {

    var i = 0
    var j = 0
    var k = k1
    while (true) {
        if (i == nums1.size) {
            return nums2[j + k - 1]
        }
        if (j == nums2.size) {
            return nums1[i + k - 1]
        }
        if (k == 1) {
            return nums1[i].coerceAtMost(nums2[j])
        }

        var half = k / 2
        var i1 = nums1.size.coerceAtMost(half + i) - 1
        var j1 = nums2.size.coerceAtMost(half + j) - 1
        if (nums1[i1] > nums2[j1]) {
            k -= j1 - j + 1
            j = j1 + 1

        } else {
            k -= i1 - i + 1
            i = i1 + 1

        }

    }


}

fun majorityElement(nums: IntArray): Int {

    var count = 0
    var ans = 0
    for (num in nums) {

        if (count == 0) {
            ans = num
        }
        count += if (num == ans) 1 else -1

    }
    return ans

}


fun isPalindrome(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false
    }
    var r = 0
    var y = x
    while (y > r) {
        r = r * 10 + y % 10
        y /= 10
    }
    return r == y || r / 10 == y

}

fun myAtoi(s: String): Int {
    var ans = 0

    if (s.isEmpty()) {
        return ans
    }
    val trim = s.trim()
    if (trim.isEmpty()) {
        return ans
    }
    var i = 1
    var j = 1
    if (trim[0] == '-') {
        j = -1
    } else if (trim[0] != '+') {
        i = 0
    }
    for (k in i until trim.length) {
        if (trim[k] < '0' || trim[k] > '9') {
            break
        }

        if (ans > Int.MAX_VALUE / 10 || (ans == Int.MAX_VALUE / 10 && trim[k] > '7')) {
            return if (j == -1) Int.MIN_VALUE else Int.MAX_VALUE
        }

        ans = ans * 10 + (trim[k] - '0')


    }
    return ans * j


}

fun climbStairs(n: Int): Int {
    var a = 0
    var b = 0
    var r = 1
    for (i in 1..n) {
        a = b
        b = r
        r = a + b

    }
    return r

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

    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        var next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev

}

// 中心扩展法
fun longestPalindrome(s: String): String {


    var start = 0
    var end = 0
    for (i in s.indices) {
        val one = findMaxLength(i, i, s)
        val two = findMaxLength(i, i + 1, s)
        val max = one.coerceAtLeast(two)
        if (max > (end - start + 1)) {
            start = i - (max - 1) / 2
            end = i + max / 2
        }


    }
    return s.substring(start, end)

}

fun findMaxLength(start: Int, end: Int, s: String): Int {

    var left = start
    var right = end
    while (left >= 0 && left < s.length && right < s.length
        && s[left] == s[right]
    ) {
        left--
        right++
    }

    return right - left - 1

}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var n1 = l1
    var n2 = l2
    var sum = 0
    var node = ListNode(-1)
    var result = node
    while (n1 != null || n2 != null) {
        var a = 0
        var b = 0
        n1 = n1?.run {
            a = `val`
            next
        }
        n2 = n2?.run {
            b = `val`
            next
        }
        var res = a + b + sum
        sum = res / 10
        node.next = ListNode(res % 10)
        node = node.next!!

    }
    if (sum != 0) {
        node.next = ListNode(sum)
    }
    return result.next
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    var n1 = l1
    var n2 = l2
    var dump = ListNode(-1)
    var res = dump
    while (n1 != null && n2 != null) {

        if (n1.`val` > n2.`val`) {
            dump.next = ListNode(n2.`val`)
            n2 = n2.next
        } else {
            dump.next = ListNode(n1.`val`)
            n1 = n1.next
        }
        dump = dump.next!!
    }
    dump.next = n1 ?: n2
    return res.next

}

fun main() {

//    var deque = ArrayDeque<Int>()
//    deque.offerFirst(1)
//    deque.offerFirst(2)
//    deque.offerFirst(3)
//
//
//    while (!deque.isEmpty()) {
//        println(deque.poll())
//    }

    println(reverse(Int.MAX_VALUE))


}

fun threeSum(nums: IntArray): List<List<Int>> {

    var result = mutableListOf<List<Int>>()
    if (nums.size < 3) {
        return result
    }
    Arrays.sort(nums)
    //  这里不能减去二
    for (i in nums.indices) {
        println("i==$i")
        if (nums[i] > 0) {
            break
        }
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        var r1 = i + 1
        var r2 = nums.size - 1
        while (r2 > r1) {
            val sum = nums[i] + nums[r1] + nums[r2]
            when {
                sum > 0 -> {
                    r2--
                }
                sum < 0 -> {
                    r1++
                }
                else -> {

                    result.add(mutableListOf(nums[i], nums[r1], nums[r2]))
                    while (r1 < r2 && nums[r1 + 1] == nums[r1]) {
                        r1++
                    }
                    while (r2 > r1 && nums[r2 - 1] == nums[r2]) {
                        r2--
                    }
                    r1++
                    r2--
                }
            }

        }

    }

    return result

}

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        if (target == nums[mid]) {
            return mid
        }
        if (nums[mid] > nums[right]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }

        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }

        }

    }
    return -1
}

fun isValid(s: String): Boolean {
    var deque = ArrayDeque<Char>()
    var map = mapOf(']' to '[', ')' to '(', '}' to '{')

    for (c in s) {

        if (map.containsKey(c)) {
            if (!deque.isEmpty() && deque.pollLast() == map[c]) {
                continue
            } else return false

        } else {
            deque.addLast(c)
        }

    }
    return deque.isEmpty()
}

fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) {
        return false
    }
    var slow = head
    var fast = head.next
    while (slow != fast) {
        if (slow == null || fast == null) {
            return false
        }
        slow = slow?.next
        fast = fast?.next?.next


    }

    return true

}


fun reverse(x: Int): Int {

    var num = x
    var result = 0
    while (num != 0) {
        var r = num % 10
        num /= 10
        if (result > Int.MAX_VALUE / 10
            || result < Int.MIN_VALUE / 10
            || (result == Int.MAX_VALUE / 10 && r > 7)
            || (result == Int.MIN_VALUE / 10 && r < -8)
        ) {
            return 0
        }
        result = result * 10 + r

    }
    return result

}

fun decodeString(s: String): String {

    var multi = ArrayDeque<Int>()
    var string = ArrayDeque<String>()
    var res = StringBuilder()
    var digit = 0

    for (c in s) {

        when {
            c == '[' -> {
                multi.addLast(digit)
                string.addLast(res.toString())
                digit = 0
                res = StringBuilder()
            }
            c == ']' -> {
                val temp = StringBuilder()
                for (i in 0 until multi.removeLast()) {
                    temp.append(res.toString())
                }
                res = StringBuilder(string.removeLast() + temp.toString())
            }
            Character.isDigit(c) -> {
                digit = digit * 10 + (c - '0')
            }
            else -> {
                res.append(c)
            }
        }

    }
    return res.toString()

}

