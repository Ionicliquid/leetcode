package java;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addToHead(node);

    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            addToHead(node);
            cache.put(key, node);
            if (++size > capacity) {
                deleteTail();
            }
        }
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        next.pre = node;
        node.next = next;
    }

    private void deleteTail() {

        Node pre = tail.pre;

        pre.pre.next = tail;
        tail.pre = pre.pre;


        cache.remove(pre.key);
        size--;


    }


    class Node {

        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}