package bytedance

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayDeque


//1. 34. 在排序数组中查找元素的第一个和最后一个位置
//2. 35. 搜索插入位置   - 完成
//3. 38. 外观数列
//4. 39. 组合总和    - 完成
//5. 40. 组合总和 II
//6. 42. 接雨水
//7. 46. 全排列   -   完成
//8. 47. 全排列 II
//9. 48. 旋转图像   - 完成
//10. 50. Pow(x, n)
//11. 51. N 皇后
//12. 53. 最大子序和
//13. 54. 螺旋矩阵   - 完成
//14. 55. 跳跃游戏
//15. 56. 合并区间   - 完成
//16. 62. 不同路径
//17. 70. 爬楼梯    - 完成
//18. 71. 简化路径  - 完成
//19. 72. 编辑距离
//20. 74. 搜索二维矩阵


fun trap(height: IntArray): Int {

    return 0


}


fun rotate(matrix: Array<IntArray>) {

    var n = matrix.size
    for(i in 0 until n){
        for(j in 0 until i){
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    for (i in 0 until n) {

        var l = 0
        var r = n - 1
        while (l < r) {
            val temp = matrix[i][l]
            matrix[i][l] = matrix[i][r]
            matrix[i][r] = temp

        }


    }

}


fun spiralOrder(matrix: Array<IntArray>): List<Int> {

    val ans = mutableListOf<Int>()

    var r = 0
    var r1 = matrix.size - 1
    var c = 0
    var c1 = matrix[0].size - 1
    while (r <= r1 && c <= c1) {

        for (i in c..c1) {
            ans.add(matrix[r][i])
        }
        for (i in r + 1..r1) {
            ans.add(matrix[i][c1])
        }
        if (r1 > r && c1 > c) {
            for (i in c1 - 1 downTo c) {
                ans.add(matrix[r1][i])
            }
            for (i in r1 - 1 downTo r + 1) {
                ans.add(matrix[i][c])

            }
        }



        r++
        r1--
        c++
        c1--


    }
    return ans

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {

    var ans = mutableListOf<IntArray>()
//    [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
    Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }
    var index = -1
    for (i in intervals.indices) {
        if (index == -1) {
            ans.add(intervals[0])
            index++
        } else {
            if (intervals[i][0] > ans[index][1]) {
                ans.add(intervals[i])
                index++
            } else {
                println(intervals[i][1])
                ans[index][1] = ans[index][1].coerceAtLeast(intervals[i][1])
            }


        }


    }



    return ans.toTypedArray()


}


fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()
    dfsB2(candidates, 0, target, path, ans)
    return ans
}

fun dfsB2(candidates: IntArray, index: Int, target: Int, path: MutableList<Int>, ans: MutableList<List<Int>>) {

    if (target == 0) {
        ans.add(path.toMutableList())
        return
    }
    for (i in index until candidates.size) {

        path.add(candidates[i])

        dfsB2(candidates, i, target - candidates[i], path, ans)


        path.removeAt(path.size - 1)


    }


}


fun searchInsert(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        when {
            target > nums[mid] -> {
                left = mid + 1

            }
            target < nums[mid] -> {
                right = mid - 1
            }
            else -> {
                return mid
            }
        }
    }
    return left
}


fun simplifyPath(path: String): String {

    val list = path.split("/")
    var queue = ArrayDeque<String>()
    for (s in list) {

        if (s == "..") {
            if (!queue.isEmpty()) queue.removeLast()
        } else if (s != "." && s != "") {
            queue.addLast(s)
        }


    }
    var ans = ""

    while (!queue.isEmpty()) {

        ans += "/" + queue.removeFirst()
    }

    return if (ans.isEmpty()) "/" else ans

}


fun permute(nums: IntArray): List<List<Int>> {

    var ans = mutableListOf<List<Int>>()
    val used = BooleanArray(nums.size)
    val path = mutableListOf<Int>()
    dfsB1(ans, used, path, nums)
    return ans

}

fun dfsB1(ans: MutableList<List<Int>>, used: BooleanArray, path: MutableList<Int>, nums: IntArray) {

    if (path.size == nums.size) {
        ans.add(path.toMutableList())
        return
    }
    for (i in nums.indices) {
        if (used[i]) continue
        path.add(nums[i])
        dfsB1(ans, used, path, nums)
        path.removeAt(path.size - 1)
    }

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
