package design


class LRUCache(capacity: Int) {
    var capacity = capacity

    var map = mutableMapOf<Int, Node>()
    var head = Node(0, 0)
    var tail = Node(0, 0)
    var size = 0

    init {
        head.next = tail
        tail.pre = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        var cache = map[key]
        if (cache != null) {
            cache.value = value
            moveToHead(cache)
        } else {
            val node = Node(value, key)
            map[key] = node
            addToHead(node)
            if (++size > capacity) {
                var node = tail.pre!!
                deleteTail(node)
                map.remove(node.key)
                size--
            }
        }

    }

    private fun deleteTail(node: Node) {
        node.pre?.next = node.next
        node.next?.pre = node.pre
    }

    private fun addToHead(node: Node) {
        node.next = head.next
        node.pre = head
        head.next?.pre = node
        head.next = node
    }

    private fun moveToHead(node: Node) {
        deleteTail(node)
        addToHead(node)

    }

    class Node(var value: Int, var key: Int) {

        var pre: Node? = null
        var next: Node? = null


    }

}