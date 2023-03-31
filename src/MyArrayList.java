import java.util.Collection;

public class MyArrayList <T>  {
    private Object[] array; // array
    private int size; //number of elements in the list

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
        for(Object element: array) {
            if(element.equals(o)) return true;
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

    }


    private void resize() {

    }
}