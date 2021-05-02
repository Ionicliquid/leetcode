package java;
// Tencent
//1.    1 两数之和                       A
//2.	206 反转链表                     A
//3.	5 最长回文串                     A
//4.	3. 无重复字符的最长子串            A
//5.	2 两数相加                       A
//6.	4 寻找2个正序数组的中位数          A
//7.	21 合并2个有序链表                A
//8.	70 爬楼梯                        A
//9.	53 最大子序和                    A
//10.	15 三数之和                      A
//11.	141 环形链表                     A
//12.	146 LRU缓存机制                 A
//13.	394 字符串解码                A
//14.	20 有效的括号                  A
//15.	8 字符串转整数                 A
//16.	215 数组中的第K的最大元素        A
//17.	9 回文数                      A   x==0 x%10==0
//18.	7 整数反转                    A
//19.	33 搜索旋转排序数组             A
//20.	169 多数元素                A


//ByteDance
//1. 1. 两数之和                      A
//2. 2. 两数相加                      A
//3. 3. 无重复字符的最长子串            A
//4. 4. 寻找两个正序数组的中位数        A
//5. 7. 整数反转                     A
//6. 8. 字符串转换整数 (atoi)         A
//7. 11. 盛最多水的容器                 A
//8. 12. 整数转罗马数字           
//8. 13. 罗马数字转整数
//10. 14. 最长公共前缀                  A
//11. 15. 三数之和                     A
//12. 18. 四数之和
//13. 19. 删除链表的倒数第 N 个结点     A
//14. 20. 有效的括号                  A
//15. 21. 合并两个有序链表             A
//16. 23. 合并K个升序链表             A
//17. 24. 两两交换链表中的节点    
//18. 25. K 个一组翻转链表
//19. 31. 下一个排列                A
//20. 33. 搜索旋转排序数组            A

import javabean.ListNode;

import java.util.*;

public class Page1 {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode tail = dump;
        ListNode pre = dump;
        while (true) {
            int count = 0;
            while (count != k && tail != null) {
                count++;
                tail = tail.next;

            }
            if (tail == null) break;
            ListNode newHead = pre.next;
            while (pre.next != tail) {
                ListNode next = pre.next;
                next.next = pre;
                pre = next;
            }


            tail = newHead;
            pre = newHead;


        }
        return dump.next;

    }

}
