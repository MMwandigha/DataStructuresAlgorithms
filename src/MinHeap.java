import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];
    private int getLeftChildIndex(int parentIndex) {return
            2*parentIndex + 1 ;}
    private int getRightChildIndex(int parentIndex) {return
            2*parentIndex + 2 ;}
    private int getParentIndex(int childIndex) {return (childIndex -
            1)/2 ;}
    private boolean hasLeftChild(int index) {return
            getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) {return
            getRightChildIndex(index) < size; }
    private boolean hasParent(int index) {return getParentIndex(index)
            >= 0; }
    private int leftChild(int index) { return
            items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return
            items[getRightChildIndex(index)]; }
    private int parent(int index) { return
            items[getParentIndex(index)]; }
    private void swap(int x, int y) {
        int temp = items[x];
        items[x] = items[y];
        items[y] = temp;
    }
    private void addCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }
    public int extract() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0]; // element we want to extract
        items[0] = items[size - 1]; // last element becomes new root
        size--;
        orderDownWards(); // maintain order
        return item;
    }

    public void delete() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0]; // element we want to extract
        items[0] = items[size - 1]; // last element becomes new root
        size--;
        orderDownWards(); // maintain order
    }
    public void add(int item) {
        addCapacity(); // create room for new member
        items[size] = item;
        size++;
        orderUpwards();
    }

    public void orderUpwards() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    public void orderDownWards() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) <
                    leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
    public static void main(String[] args) {
        MinHeap ourHeapStructure = new MinHeap();
        ourHeapStructure.add(23);
        ourHeapStructure.add(67);
        ourHeapStructure.add(12);
        ourHeapStructure.add(8);
        ourHeapStructure.add(17);
        ourHeapStructure.add(29);
        System.out.println("End of addition, min element is: " + ourHeapStructure.peek());
        int savedElement = ourHeapStructure.extract();
        System.out.println(savedElement + " has been extracted, new min is: " + ourHeapStructure.peek());

        ourHeapStructure.delete();
        System.out.println("Min element has been deleted, new min is: " + ourHeapStructure.peek());
    }

}
