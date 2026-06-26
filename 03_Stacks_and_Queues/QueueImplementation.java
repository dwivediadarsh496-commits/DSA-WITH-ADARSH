/**
 * QueueImplementation
 * 
 * Implements Queue data structure in three ways:
 * 1. Array-based linear queue (fixed size, potential wasted space)
 * 2. Circular queue (fixed size, reuse memory spaces)
 * 3. LinkedList-based queue (dynamic size)
 * 
 * Operations: Enqueue (Insert), Dequeue (Remove), Front (Peek), isEmpty.
 * Time Complexity for all basic operations: O(1)
 */
public class QueueImplementation {

    // --- 1. Array-Based Linear Queue ---
    static class ArrayQueue {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int nItems;

        public ArrayQueue(int size) {
            this.maxSize = size;
            this.queueArray = new int[maxSize];
            this.front = 0;
            this.rear = -1;
            this.nItems = 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue Overflow! Cannot enqueue " + value);
                return;
            }
            queueArray[++rear] = value;
            nItems++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow! Cannot dequeue.");
                return -1;
            }
            int temp = queueArray[front++];
            nItems--;
            return temp;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return queueArray[front];
        }

        public boolean isEmpty() {
            return (nItems == 0);
        }

        public boolean isFull() {
            return (rear == maxSize - 1);
        }

        public void display() {
            System.out.print("Array Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    // --- 2. Circular Queue ---
    static class CircularQueue {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int nItems;

        public CircularQueue(int size) {
            this.maxSize = size;
            this.queueArray = new int[maxSize];
            this.front = 0;
            this.rear = -1;
            this.nItems = 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Circular Queue Overflow! Cannot enqueue " + value);
                return;
            }
            // Circular wrap-around of rear pointer
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            nItems++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Circular Queue Underflow! Cannot dequeue.");
                return -1;
            }
            int temp = queueArray[front];
            // Circular wrap-around of front pointer
            front = (front + 1) % maxSize;
            nItems--;
            return temp;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty.");
                return -1;
            }
            return queueArray[front];
        }

        public boolean isEmpty() {
            return (nItems == 0);
        }

        public boolean isFull() {
            return (nItems == maxSize);
        }

        public void display() {
            System.out.print("Circular Queue: ");
            int count = 0;
            int idx = front;
            while (count < nItems) {
                System.out.print(queueArray[idx] + " ");
                idx = (idx + 1) % maxSize;
                count++;
            }
            System.out.println();
        }
    }

    // --- 3. LinkedList-Based Queue ---
    static class LinkedListQueue {
        static class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node front;
        private Node rear;

        public LinkedListQueue() {
            this.front = null;
            this.rear = null;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow! Cannot dequeue.");
                return -1;
            }
            int temp = front.data;
            front = front.next;
            if (front == null) {
                rear = null; // List becomes empty
            }
            return temp;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return front.data;
        }

        public boolean isEmpty() {
            return (front == null);
        }

        public void display() {
            System.out.print("LinkedList Queue: ");
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Array Linear Queue ===");
        ArrayQueue q1 = new ArrayQueue(5);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.display(); // Expected: 10 20 30
        System.out.println("Dequeue: " + q1.dequeue()); // Expected: 10
        q1.display(); // Expected: 20 30

        System.out.println("\n=== Testing Circular Queue ===");
        CircularQueue q2 = new CircularQueue(3);
        q2.enqueue(100);
        q2.enqueue(200);
        q2.enqueue(300);
        q2.display(); // Expected: 100 200 300
        System.out.println("Dequeue: " + q2.dequeue()); // Expected: 100
        q2.enqueue(400); // circular insertion
        q2.display(); // Expected: 200 300 400

        System.out.println("\n=== Testing LinkedList Queue ===");
        LinkedListQueue q3 = new LinkedListQueue();
        q3.enqueue(1000);
        q3.enqueue(2000);
        q3.enqueue(3000);
        q3.display(); // Expected: 1000 2000 3000
        System.out.println("Dequeue: " + q3.dequeue()); // Expected: 1000
        q3.display(); // Expected: 2000 3000
    }
}
