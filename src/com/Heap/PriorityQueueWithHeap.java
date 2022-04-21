package com.Heap;

public class PriorityQueueWithHeap {
    private  Heap heap = new Heap();
    public void enQueue(int value){
        heap.insert(value);
    }
    public int deQueue(){
        return heap.remove();
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    //kth largest
    public  int kthLargest(int[] array,int k){
        int a = 0;
        for(var i = 0;i<array.length;i++)
            heap.insert(array[i]);
        if(heap.isEmpty())
            throw new IllegalStateException();
        for(var i = 1;i<= k;i++){
            a = heap.remove();
        }
        return a;
    }
}
