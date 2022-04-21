package com.Heap;

public class Heap {
    private int[] array = new int[10];
    private int size;

    //this insert method bubbles up only once
    public void insert(int value){
        if(isFull())
            throw new IllegalStateException();

        array[size++] = value;

        bubbleUp();
        }
    public boolean isFull(){
        return size == array.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(){
        var index = size - 1;
        while(index > 0 && array[index] > array[parent(index)]) {
            swap(index,parent(index));
            index = parent(index);
    }
    }
    //removes root
    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();

        var root = array[0];
        array[0] = array[--size];

        bubbleDown();

        return root;
    }
    private void bubbleDown(){
        var index = 0;
        while(index <= size && !isValidParent(index)){
            swap(index,largerChildIndex(index));
            index = largerChildIndex(index);
        }
    }
    private void swap(int first,int second){
        var temp = array[first];
        array[first] =array[second];
        array[second] = temp;
    }
    private int largerChildIndex(int index){
        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }
    private boolean hasLeftChild(int index){
        return size >= leftChildIndex(index);
    }
    private boolean hasRightChild(int index){
        return size >= rightChildIndex(index);
    }
    private boolean isValidParent(int index){
        if(!hasLeftChild(index))
            return true;
        if(!hasRightChild(index))
            return array[index] >= leftChild(index);

        return array[index] >= leftChild(index) && array[index] >= rightChild(index);
    }
    private int leftChild(int index){
        return array[leftChildIndex(index)];
    }
    private int rightChild(int index){
        return array[rightChildIndex(index)];
    }
    private int leftChildIndex(int index){
        return index * 2 + 1;
    }
    private int rightChildIndex(int index){
        return index * 2 + 2;
    }
    private int parent(int index){
        return (index - 1) / 2;
    }
}
