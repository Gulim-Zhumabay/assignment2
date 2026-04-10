package ads;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    private MyNode getNode(int index) {
        checkIndex(index);
        if (index < size / 2) {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            MyNode current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        MyNode current = getNode(index);
        MyNode newNode = new MyNode(item);
        MyNode previous = current.prev;

        newNode.prev = previous;
        newNode.next = current;
        previous.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode current = getNode(index);
        MyNode previous = current.prev;
        MyNode next = current.next;

        previous.next = next;
        next.prev = previous;

        current.next = null;
        current.prev = null;
        current.data = null;

        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head.data = null;
            head = null;
            tail = null;
        } else {
            MyNode newHead = head.next;
            head.next = null;
            head.data = null;
            newHead.prev = null;
            head = newHead;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            tail.data = null;
            head = null;
            tail = null;
        } else {
            MyNode newTail = tail.prev;
            tail.prev = null;
            tail.data = null;
            newTail.next = null;
            tail = newTail;
        }
        size--;
    }

    @Override
    public void sort() {
        if (size < 2) {
            return;
        }

        for (MyNode i = head; i != null; i = i.next) {
            MyNode min = i;
            for (MyNode j = i.next; j != null; j = j.next) {
                if (j.data.compareTo(min.data) < 0) {
                    min = j;
                }
            }
            T temp = i.data;
            i.data = min.data;
            min.data = temp;
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;

        while (current != null && index < size) {
            if (object == null) {
                if (current.data == null) {
                    return index;
                }
            } else if (object.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        int steps = 0;

        while (current != null && steps < size) {
            if (object == null) {
                if (current.data == null) {
                    return index;
                }
            } else if (object.equals(current.data)) {
                return index;
            }
            current = current.prev;
            index--;
            steps++;
        }

        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        int index = 0;

        while (current != null && index < size) {
            result[index] = current.data;
            current = current.next;
            index++;
        }

        return result;
    }

    @Override
    public void clear() {
        MyNode current = head;
        int count = 0;

        while (current != null && count < size) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
            count++;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            private int traversed = 0;

            @Override
            public boolean hasNext() {
                return current != null && traversed < size;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                traversed++;
                return value;
            }
        };
    }
}