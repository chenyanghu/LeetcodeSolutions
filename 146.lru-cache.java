/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
class LRUCache {
    class DNode{
        int key;
        int value;
        DNode pre;
        DNode next;
    
        public DNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, DNode> map;
    int capacity, count;
    DNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DNode(0, 0);
        tail = new DNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }
    
    private void addToHead(DNode node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void delete(DNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if(map.get(key) != null){
            DNode node = map.get(key);
            int result = node.value;
            delete(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null){
            DNode node = map.get(key);
            node.value = value;
            delete(node);
            addToHead(node);
        }
        else{
            DNode node = new DNode(key, value);
            map.put(key, node);
            if(count < capacity){
                count++;
                addToHead(node);
            }
            else{
                // remove the tail node
                map.remove(tail.pre.key);
                delete(tail.pre);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

