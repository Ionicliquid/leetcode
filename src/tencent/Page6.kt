package tencent

import bean.ListNode

//1.    226 翻转二叉树
//2.	120 三角形的最小路径和
//3.	49 字母异位词分组
//4.	75 颜色分类
//5.	122 买卖股票的最佳时机Ⅱ        - 完成
//6.	45 跳跃游戏Ⅱ
//7.	108 将有序数组转换为二叉搜索树
//8.	128 最长连续序列
//9.	135 分发糖果
//10.	557 反转字符串中的单词Ⅱ
//11.	704 二分查找                 - 完成
//12.	178 分数排名                 - 完成
//13.	191 位1的个数
//14.	349 2个数组的交集
//15.	153 寻找旋转数组中的最小值
//16.	30 串联所有单词的子串
//17.	203 移除链表元素            - 完成
//18.	283 移动零
//19.	260 只出现一次的数字Ⅱ
//20.	213 打家劫舍Ⅱ


fun maxProfit2(prices: IntArray): Int {

    var max = 0
    for (i in 1 until prices.size) {

        if (prices[i] > prices[i - 1]) {
            max += prices[i] - prices[i - 1]
        }

    }
    return max
}


fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var node = head
    var dump: ListNode? = ListNode(-1)
    dump?.next = head
    var ans = dump
    while (node != null) {
        if (node.`val` == `val`) {
            dump?.next = node.next
        } else {
            dump = node
        }
        node = node.next

    }
    return ans?.next

}


fun search1(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        when {
            target == nums[mid] -> {
                return mid
            }
            target > nums[mid] -> {
                left++
            }
            else -> {
                right--
            }
        }
    }
    return -1

}