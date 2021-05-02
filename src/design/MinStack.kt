package design

class MinStack() {

    /** initialize your data structure here. */

    var stack1 = ArrayDeque<Int>()
    var stack2 = ArrayDeque<Int>()


    fun push(x: Int) {
        stack2.addLast(x)
        if (stack1.isEmpty() || x <= stack1.last()) {
            stack1.addLast(x)

        }
    }

    fun pop() {
        if(stack1.last()== stack2.removeLast()){
            stack1.removeLast()
        }
    }

    fun top(): Int {
        return stack2.last()
    }

    fun getMin(): Int {
        return stack1.last()
    }

}