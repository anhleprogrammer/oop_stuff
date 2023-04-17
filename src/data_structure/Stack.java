package data_structure;

public class Stack<T> {
    T[] arr;
    int ARR_DEFAULT_LEN = 10;
    int arrLen = ARR_DEFAULT_LEN;

    int size;

    T top;
    public Stack() {
        arr = (T[]) new Object[arrLen];
        size = 0;
        top = null;
    }

    public int size() {
        return size;
    }
    //push(E element): Adds an element to the top of the stack.
    public T push(T element) {
        //size is number of element inside the array so add to the top is add to index equal size
        //
        if(size == arrLen) {
            Object[] newArr =   new Object[arrLen * 2];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = (T[]) newArr;
        }
        arr[size] = element;
        top = element;
        size++;
        return element;
    }
    //pop(): Removes and returns the element at the top of the stack.
    public T pop() {
        if(size == 0) return null;
        T result = arr[size - 1];
        arr[size - 1] = null;
        size--;
        top = arr[size - 1];
        return result;
    }
    //peek(): Returns the element at the top of the stack without removing it.
    public T peek() {
        if(size == 0) return null;
        return arr[size - 1];
    }
    //empty(): Returns true if the stack is empty, false otherwise.
    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
    // search(Object o): Returns the 1-based position of the element
    // on the stack, counting from the top. Returns -1 if the element is not on the stack
    public int search(Object o){
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == o) return i;
        }
        return -1;
    }

    public void printStack() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);

        System.out.println("Element at the top of stack: " + stack.peek());
        stack.push(3);
        System.out.println("Index of element with value 3: " +  stack.search(3));
        stack.push(4);
        stack.pop();

        stack.printStack();
    }
}
