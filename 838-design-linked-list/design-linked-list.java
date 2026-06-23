class MyLinkedList {
    private class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node headSentinel;
    private Node tailSentinel;
    private int size;

    public MyLinkedList() {
        headSentinel = new Node(0);
        tailSentinel = new Node(0);
        headSentinel.next = tailSentinel;
        tailSentinel.prev = headSentinel;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node node = getNodeAt(index);
        return node.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        Node after = headSentinel.next;
        headSentinel.next = newNode;
        newNode.prev = headSentinel;
        newNode.next = after;
        after.prev = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node before = tailSentinel.prev;
        before.next = newNode;
        newNode.prev = before;
        newNode.next = tailSentinel;
        tailSentinel.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node successor;
        Node predecessor;
        if (index == size) {
            successor = tailSentinel;
            predecessor = tailSentinel.prev;
        } else {
            successor = getNodeAt(index);
            predecessor = successor.prev;
        }
        Node newNode = new Node(val);
        newNode.prev = predecessor;
        newNode.next = successor;
        predecessor.next = newNode;
        successor.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node node = getNodeAt(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private Node getNodeAt(int index) {
        Node node;
        if (index < size / 2) {
            node = headSentinel.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tailSentinel.prev;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }
}