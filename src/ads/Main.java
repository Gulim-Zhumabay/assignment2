package ads;

public class Main {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
        testMinHeap();
    }

    private static void testArrayList() {
        System.out.println("MyArrayList");

        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(30);
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(40);
        list.add(2, 15);

        printList(list);

        System.out.println(list.get(2));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.set(2, 17);
        printList(list);

        System.out.println(list.indexOf(20));
        System.out.println(list.lastIndexOf(40));
        System.out.println(list.exists(10));

        Object[] array = list.toArray();
        printArray(array);

        list.remove(2);
        list.removeFirst();
        list.removeLast();
        printList(list);

        list.sort();
        printList(list);

        System.out.println(list.size());

        list.clear();
        System.out.println(list.size());

        System.out.println();
    }

    private static void testLinkedList() {
        System.out.println("MyLinkedList");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(30);
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(40);
        list.add(2, 15);

        printList(list);

        System.out.println(list.get(2));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.set(2, 17);
        printList(list);

        System.out.println(list.indexOf(20));
        System.out.println(list.lastIndexOf(40));
        System.out.println(list.exists(10));

        Object[] array = list.toArray();
        printArray(array);

        list.remove(2);
        list.removeFirst();
        list.removeLast();
        printList(list);

        list.sort();
        printList(list);

        System.out.println(list.size());

        list.clear();
        System.out.println(list.size());

        System.out.println();
    }

    private static void testStack() {
        System.out.println("MyStack");

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        System.out.println();
    }

    private static void testQueue() {
        System.out.println("MyQueue");

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        System.out.println();
    }

    private static void testMinHeap() {
        System.out.println("MyMinHeap");

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(30);
        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(40);
        heap.add(2);

        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        System.out.println(heap.size());
        System.out.println(heap.isEmpty());

        System.out.println();
    }

    private static <T extends Comparable<T>> void printList(MyList<T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}