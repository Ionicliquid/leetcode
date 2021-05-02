package design

class CQueue() {

    var stack1 = ArrayDeque<Int>()
    var stack2 = ArrayDeque<Int>()

    fun appendTail(value: Int) {
        stack1.addLast(value)
    }

    fun deleteHead(): Int {
        if (stack1.isEmpty() && stack2.isEmpty()) return -1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast())
            }
            return stack2.removeLast()
        }
        return stack2.removeLast()
    }

}