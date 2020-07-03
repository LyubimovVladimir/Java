package homework.seven;

public class TwoDirectionalList implements DirectionalListTwo {
    private Node first;
    private Node previous;

    @Override
    public void add(String val) {
        if(first == null){
            first = new Node(val, null, null);
            previous = first;
            return;
        }
        add(val, first, first);
    }

    private void add(String val, Node current, Node previous) {
        if(current.getNext() == null) {
            current.setNext(new Node(val, current, null));
        } else {
            add(val, current.getNext(), current);
        }
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }

        int size = 1;

        Node current = first;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public boolean remove(String val) {
        if (first.getVal().equals(val)) {
            if (first.getNext() == null && first.getPrev() == null) {
                first = null;
            } else {
                first = first.getNext();
            }
            return true;
        }

        Node current = first.getNext();
        Node prev = previous;

        while (current != null) {
            if (current.getVal().equals(val)) {
                prev.setNext(current.getNext());
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }

        return false;
    }

    @Override
    public Node getFirst() {
        return first;
    }

    public class Node{
        private String val;
        private Node prev;
        private Node next;

        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
