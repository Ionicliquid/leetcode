package design

class MyQueue() {

    /** Initialize your data structure here. */

    var s1 = ArrayDeque<Int>()
    var s2 = ArrayDeque<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        s1.addLast(x)

    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (s2.isEmpty()) {

            val size = s1.size
            for (i in 0..size) {
                s2.addLast(s1.removeLast())
            }
        }
        return s2.removeLast()

    }

    /** Get the front element. */
    fun peek(): Int {
        if (s2.isEmpty()) {
            val size = s1.size
            for (i in 0..size) {
                s2.addLast(s1.removeLast())
            }

        }
        return s2.last()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }

}