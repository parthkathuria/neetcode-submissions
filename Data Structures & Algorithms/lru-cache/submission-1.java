class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node mostRecent;
    Node leastRecent;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.leastRecent = new Node(0, 0);
        this.mostRecent = new Node(0, 0);
        this.leastRecent.next = this.mostRecent;
        this.mostRecent.prev = this.leastRecent;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node n = this.cache.get(key);
            this.remove(n);
            this.insert(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            Node n = this.cache.get(key);
            this.remove(n);
            this.insert(n);
            n.val = value;
        } else {
            Node n = new Node(key, value);
            this.cache.put(key, n);
            this.insert(n);
            if (this.cache.size() > this.capacity) {
                Node lru = this.leastRecent.next;

                this.cache.remove(lru.key);
                this.remove(lru);
            }
        }
    }

    private void insert(Node node) {
        node.prev = this.mostRecent.prev;
        node.next = this.mostRecent;
        this.mostRecent.prev.next = node;
        this.mostRecent.prev = node;
        this.mostRecent.next = null;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
