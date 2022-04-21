package com.Heap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // heap class implementation:-

//            var heap = new Heap();
//            heap.insert(10);
//            heap.insert(5);
//            heap.insert(17);
//            heap.insert(4);
//            heap.insert(22);
//            heap.remove();
//        System.out.println("done");
//

        // using heap class  to sort :-

        int[] numbers = {5,3,10,1,4,2};
        var heap = new Heap();
        for(var number : numbers){
            heap.insert(number);
        }
        for(var i = numbers.length -1;i >= 0;i --)
            numbers[i] = heap.remove();
        System.out.println(Arrays.toString(numbers));


       //kth largest
        var pq = new PriorityQueueWithHeap();
        int[] number = {5,3,10,1,4,2};
        var a = pq.kthLargest(number,6);
        System.out.println(a);
    }
}
