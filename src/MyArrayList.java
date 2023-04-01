import java.util.Arrays;
import java.util.Collection;

public class MyArrayList <T>  {
    private static Object[] array; // array
    private static int size; //number of elements in the list

    private final static int DEFAULT_SIZE = 10; // default size of array

    private int arrayLength = DEFAULT_SIZE; // array capacity

    public MyArrayList() {
        //create an array with default size and there's no element so size of the list is 0
        array = new Object[DEFAULT_SIZE];
        size = 0;
    }


    public MyArrayList(Collection<? extends T> c) {
        array = new Object[c.size()];
        size = 0;
        for(T element: c) {
            array[size] = element;
            size++;
        }
    }


    public MyArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
        size = 0;
     }

     public int size() {
        return this.size;
     }


    public void add(T object) {
        //add to the end of the array
        //check length of underlying array, if it is equal we have to resize to add new element
        if(arrayLength == size) {

            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = object;
        size++;
    }


    public void add(T object, int index) {
        if(index < 0 || index > size) {
            //If the index is out of bound then throw exception
            throw new IndexOutOfBoundsException();
        }
        if(arrayLength == size) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        for(int i = size - 1; i >=  index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = object;
        size++;
    }


    public void clear() {
        array = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public boolean contains(Object o) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(o)) return true;
        }
        return false;
    }

    public Object get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }


    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--) {
            if(array[i].equals(o)) return i;
        }
        return -1;
     }


    public void remove(int index) {
        //check if index is valid
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = index + 1; i < size; i++) {
           array[i-1] = array[i];
        }
        array[size - 1] = null;
        size--;
    }


    public void remove(Object o) {
        int startIndex = 0;
        for(int i = 0; i < size; i++) {
            if(array[i].equals(o)) {
                startIndex = i;
                break;
            }
        }
        for(int i = startIndex; i < size; i++) {
            if(i == size - 1) array[i] = null;
            else array[i] = array[i + 1];
        }
        size--;
    }

    public Object set(Object o, int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = o;
        return array[index];
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(array, 0, result,0, size);
        return result;
    }


    public static void main(String[] args) {
        // Create a new MyArrayList
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Test the add method
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList.size()); // Expected output: 3

        // Test the add method with index
        myList.add(4, 1);
        System.out.println(myList.size()); // Expected output: 4
        System.out.println(myList.get(1)); // Expected output: 4

        // Test the contains method
        System.out.println(myList.contains(3)); // Expected output: true
        System.out.println(myList.contains(5)); // Expected output: false

        // Test the get method
        System.out.println(myList.get(2)); // Expected output: 2

        // Test the indexOf method
        System.out.println(myList.indexOf(2)); // Expected output: 2

        // Test the isEmpty method
        System.out.println(myList.isEmpty()); // Expected output: false
        System.out.println(Arrays.toString(array) + " " + size);

        // Test the lastIndexOf method
        myList.add(2);
        System.out.println(myList.lastIndexOf(2)); // Expected output: 4
        System.out.println(Arrays.toString(array) + " " + size);

        // Test the remove method
        myList.remove(0);
        System.out.println(myList.size()); // Expected output: 4
        System.out.println(myList.get(0)); // Expected output: 4
        System.out.println(Arrays.toString(array) + " " + size);

        // Test the set method
        myList.set(5, 1);
        System.out.println(myList.get(1)); // Expected output: 5

        System.out.println(Arrays.toString(array) + " " + size);
        // Test the toArray method
        Object[] arr = myList.toArray();
        System.out.println(Arrays.toString(arr) + " " + size);

        // Expected output: 4 5 3 2 2

    }
}