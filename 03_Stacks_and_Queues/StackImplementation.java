/**
 * StackImplementation
 * 
 * Implements Stack data structure in two ways:
 * 1. Array-based implementation (Fixed size, fast access)
 * 2. LinkedList-based implementation (Dynamic size, no overflow)
 * 
 * Operations: Push, Pop, Peek, isEmpty.
 * Time Complexity for all basic operations: O(1)
 */
public class StackImplementation {

    // --- 1. Array-Based Stack Implementation ---
    static class ArrayStack {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public ArrayStack(int size) {
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1; // Stack is initially empty
        }

        // Push element onto stack
        // Time Complexity: O(1)
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + value);
                return;
            }
            stackArray[++top] = value;
        }

        // Pop element from stack
        // Time Complexity: O(1)
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop.");
                return -1;
            }
            return stackArray[top--];
        }

        // Peek top element of stack
        // Time Complexity: O(1)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return stackArray[top];
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return (top == -1);
        }

        // Check if stack is full
        public boolean isFull() {
            return (top == maxSize - 1);
        }

        public void display() {
            System.out.print("Array Stack (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // --- 2. LinkedList-Based Stack Implementation ---
    static class LinkedListStack {
        static class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node top;

        public LinkedListStack() {
            this.top = null;
        }

        // Push element onto stack
        // Time Complexity: O(1)
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        // Pop element from stack
        // Time Complexity: O(1)
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop.");
                return -1;
            }
            int poppedValue = top.data;
            top = top.next;
            return poppedValue;
        }

        // Peek top element of stack
        // Time Complexity: O(1)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return top.data;
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return (top == null);
        }

        public void display() {
            System.out.print("LinkedList Stack (top to bottom): ");
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Driver method to test both implementations
    public static void main(String[] args) {
        System.out.println("=== Testing Array-Based Stack ===");
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.display(); // Expected: 30 20 10
        System.out.println("Peek: " + arrayStack.peek()); // Expected: 30
        System.out.println("Pop: " + arrayStack.pop());   // Expected: 30
        arrayStack.display(); // Expected: 20 10

        System.out.println("\n=== Testing LinkedList-Based Stack ===");
        LinkedListStack llStack = new LinkedListStack();
        llStack.push(100);
        llStack.push(200);
        llStack.push(300);
        llStack.display(); // Expected: 300 200 100
        System.out.println("Peek: " + llStack.peek()); // Expected: 300
        System.out.println("Pop: " + llStack.pop());   // Expected: 300
        llStack.display(); // Expected: 200 100
    }
}
