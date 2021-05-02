package design

class MyStack() {

    /** Initialize your data structure here. */

    var deque = ArrayDeque<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        deque.addLast(x)
        var size = deque.size
        for (i in 1 until size) {
            deque.addLast(deque.removeFirst())
        }


    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return deque.removeFirst()
    }

    /** Get the top element. */
    fun top(): Int {
        return deque.first()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return deque.isEmpty()
    }

}