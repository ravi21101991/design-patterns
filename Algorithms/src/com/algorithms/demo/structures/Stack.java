package com.algorithms.demo.structures;

/**
 * This class represents Stack data structure. It allows the access in Last In
 * First Out(LIFO) manner. So the element added last will be the element which
 * is removed first if pop is called.
 */
public class Stack {

    private static String[] stack;

    private static int stackSize;

    private static int topOfStack = -1;

    private static final String EMPTY_STRING = "";

    private static final int DEFAULT_LENGTH = 10;

    public Stack(int size) {
        stackSize = size;
        stack = new String[size];
    }

    private static void printStack() {
        System.out.println("\nCURRENT STACK:");
        int maxLentgh = maxLength();
        maxLentgh = maxLentgh == 0 ? DEFAULT_LENGTH : maxLentgh;

        System.out.println(createStackRow(maxLentgh, EMPTY_STRING, true));
        for (int i = stackSize - 1; i >= 0; i--) {
            System.out.print(createStackRow(maxLentgh, stack[i], false));
            if (i == topOfStack) {
                System.out.print("<==TOP OF STACK");
            }
            System.out.println();
            System.out.println(createStackRow(maxLentgh, EMPTY_STRING, true));
        }
    }

    private static String createStackRow(int maxLength, String val, boolean isHeadOrFoot) {
        val = val == null ? "" : val;
        int toAppend = val == null ? 0 : val.length();
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        if (toAppend == 0 && isHeadOrFoot) {
            for (int i = 0; i <= maxLength; i++) {
                builder.append("-");
            }
        } else {
            int whiteSpaces = maxLength - toAppend;
            builder.append(val);
            for (int i = 0; i <= whiteSpaces; i++) {
                builder.append(" ");
            }
        }
        builder.append("|");
        return builder.toString();
    }

    private static int maxLength() {
        int maxLength = 0;
        for (int i = 0; i < stackSize; i++) {
            if (stack[i] != null) {
                if (stack[i].length() > maxLength) {
                    maxLength = stack[i].length();
                }
            }
        }
        return maxLength;
    }

    public void push(String val) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stack[topOfStack] = val;
            System.out.printf("\n ++PUSH: %s\n", stack[topOfStack]);
            printStack();
        }
        else
            System.out.printf("\nSorry the element \"%s\" could not be added to the stack as it is full.", val);
    }

    public void pop() {
        if (topOfStack >= 0) {
            System.out.printf("\n --POP: %s\n", stack[topOfStack]);
            stack[topOfStack] = null;
            topOfStack--;
            printStack();
        } else
            System.out.println("Sorry cannot perform POP as the stack is empty.");
    }

    public void peek() {
        System.out.println("~~PEEK: " + stack[topOfStack]);
        printStack();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push("element 1");
        stack.push("element 2");
        stack.peek();
        stack.pop();
    }
}
