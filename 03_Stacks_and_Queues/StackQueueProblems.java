import java.util.Stack;

/**
 * StackQueueProblems
 * 
 * Implements standard interview questions based on Stacks and Queues:
 * 1. Balanced Parentheses -> O(N) Time, O(N) Space
 * 2. Min Stack -> All operations O(1) Time, O(N) Space
 * 3. Queue using two Stacks -> Enqueue O(1) Time, Dequeue O(1) Amortized Time, O(N) Space
 */
public class StackQueueProblems {

    // --- 1. Balanced Parentheses Checker ---
    // Goal: Given a string containing brackets, determine if the bracket pairs are valid.
    // Time Complexity: O(N), Space Complexity: O(N)
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // unmatched closing bracket or empty stack
            }
        }
        return stack.isEmpty();
    }

    // --- 2. Min Stack Implementation ---
    // Goal: Design a stack that supports push, pop, top, and retrieving the minimum element in O(1) time.
    static class MinStack {
        private Stack<Integer> mainStack;
        private Stack<Integer> minStack; // keeps track of the running minimums

        public MinStack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            mainStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (mainStack.isEmpty()) return;
            int removed = mainStack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // --- 3. Queue using Stacks (efficient dequeue) ---
    // Goal: Implement a queue using two stacks.
    // Time Complexity: Enqueue O(1), Dequeue O(1) Amortized
    static class QueueUsingStacks {
        private Stack<Integer> s1; // For pushing new items
        private Stack<Integer> s2; // For popping items

        public QueueUsingStacks() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // Push element x to the back of queue
        public void enqueue(int x) {
            s1.push(x);
        }

        // Removes the element from in front of queue
        public int dequeue() {
            shiftStacks();
            if (s2.isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            return s2.pop();
        }

        // Get the front element
        public int peek() {
            shiftStacks();
            if (s2.isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }
            return s2.peek();
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        // Helper to transfer elements from s1 to s2 when s2 is empty
        private void shiftStacks() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }

    // Driver method to test the problems
    public static void main(String[] args) {
        System.out.println("--- Test 1: Balanced Parentheses ---");
        String s1 = "()[{}()]";
        String s2 = "([)]";
        System.out.println(s1 + " is valid? " + isValidParentheses(s1)); // Expected: true
        System.out.println(s2 + " is valid? " + isValidParentheses(s2)); // Expected: false

        System.out.println("\n--- Test 2: Min Stack ---");
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current Min: " + minStack.getMin()); // Expected: -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());           // Expected: 0
        System.out.println("Current Min: " + minStack.getMin()); // Expected: -2

        System.out.println("\n--- Test 3: Queue Using Stacks ---");
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Peek: " + queue.peek());       // Expected: 1
        System.out.println("Dequeue: " + queue.dequeue()); // Expected: 1
        System.out.println("Dequeue: " + queue.dequeue()); // Expected: 2
        System.out.println("IsEmpty: " + queue.isEmpty()); // Expected: false
    }
}
