package data_structure;

public class Queue<T> {

    T[] arr;
    int ARR_DEFAULT_LEN = 10;
    int arrLen = ARR_DEFAULT_LEN;

    int size;

    T top;
    public Queue() {
        arr = (T[]) new Object[arrLen];
        size = 0;
        top = null;
    }
    //enqueue : add an element to the end of the queue and return true if successful

    //Adds an element to the back of the queue. Returns true if successful, false otherwise.
    public boolean enqueue(T element){
        if(size == arrLen) return false;
        arr[size] = element;
        size++;
        return true;
    }
    //remove element at the front of the queue
    public T dequeue(){
        if(size == 0) return null;
        T result = arr[0]; //assuming T is a primitive type
        for(int i = 1; i < size; i++) {
            if(i == size) arr[i] = null;
            arr[i - 1] = arr[i];
        }
        size--;
        return result;
    }
    //Returns the element at the front of the queue without removing it.
    // //Returns null if the queue is empty.
    public T peek() {
        if(size == 0) return null;
        return arr[0];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
}
