'use strict';
//Simple ol' school swap function  
var swap = function(arr,pos1,pos2){
    let temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
    return arr;
}

/* Quick Sort:

To be filled */

function quicksort(data) {
    if (data.length == 0) return [];
  
    var left = [], right = [], pivot = data[0];
  
    for (var i = 1; i < data.length; i++) {
        if(data[i] < pivot)
            left.push(data[i])
        else
            right.push(data[i]);
    }
  
    return quicksort(left).concat(pivot, quicksort(right));
}

/*Selection Sort:
    1) Splits the array into two portions 
        a. Sorted portion
        b. Unsorted portion
    2) Inititally the sorted portion is empty and all the elements are present in the unsorted portion.
    3) Iterates over the unsorted portion of array, finds the smallest in the array and adds it to the sorted portion as follows:
        a. Assumes the current postion(or the first element) in the unsorted portion as the smallest element and assigns it to the "smallest" variable.
        b. It assigns the smallest position to the initial position of the unsorted array in the "smallestPos" variable.
        c. With that as reference, it iterates over the remaining elements. When a smaller number is found, it replaces the "smallestPos" with the current
        postion and "smallest" with the current variable.
    
  Performance Analysis:
       Worst case:O(n^2) 
       Best Case: O(n^2)
                        => Since no matter what, it has to compare the current element with each and every other element 
                            in the array to find the smallest in the unsorted portion;
*/
var selectionSort = function(arr){
    for(let i=0;i<arr.length;i++){
        let smallest=arr[i];
        let smallestPos = i;
        for(let j=i+1;j<arr.length;j++){
            if(arr[j]<smallest){
                smallest = arr[j];
                smallestPos = j;
            }          
        }
        arr[smallestPos] = arr[i];
        arr[i] = smallest;
    }
    return arr;
};

var input = [50,40,1,20,11,6];
console.log(`selection sorted = ${selectionSort(input)}`);


/*Insertion Sort:
    1) Splits the array into two portions 
        a. Sorted portion
        b. Unsorted portion
    2) Inititally the sorted portion is empty and all the elements are present in the unsorted portion.
    3) Iterates over the unsorted portion of array, finds the smallest in the array and adds it to the sorted portion as follows:
        a. Looks for the first element in the unsorted portion.
        b. Compares against the last element in the sorted portion. 
            b1. If the element is larger than the last element in the sorted portion, it stays put. The unsorted index shifts by 1 position.
            b2. If the element is smaller than the last element, swap. Then check against the previous element.
            b3. Continue this process untill no more sorting
        c. Move the unsorted start index by 1 position
    
  Performance Analysis:
       Worst case:O(n^2)=> In worst case(array is reverse sorted), each and every element in the unsorted portion would have to iterate over
                            each and every element in the sorted portion.
       Best Case: O(n) => If the array is already sorted, it has to iterate over the array only once.
*/

var insertionSort = function(arr){
    for(let i=0;i<arr.length;i++){
        if(arr[i]>arr[i+1]){
            swap(arr,i,i+1);
        }
        let pos =i;
        while(pos>=0){
            if(arr[pos-1]>arr[pos]){
                swap(arr,pos,pos-1);
                pos--;
            } else{
                break;
            }
        }
    }
    return arr;
};
var input = [50,40,1,20,11,6];
console.log(`insertion sorted = ${insertionSort(input)}`);


/*                                Bubble Sort
                                 ---------------
Introduction:
==============
 1) Compares each element in an array with its adjacent element. 
 2) If the one on the right hand side is greater(or lesser based on the
     order of sort required) the elements are swapped.
 3) This iteration is performed multiple times untill, there is one iteration
     which makes no swaps
     
Process: 
========     
 Consider:[3,4,1,2] should be sorted in ascending order
 
 Iteration 1:
     Input: [3,4,1,2]
     Step 1: compare 3 and 4. 3 <4 => no change => [3,4,1,2]
     Step 2: Compare 4 and 1. 4 > 1 => swap => [3,1,4,2]
     Step 3: Compare 4 and 2. 4 > 2 => swap => [3,1,2,4]
     Result: [3,1,2,4] => Greatest element has moved to its position(the end)
     swapped = true
Iteration 2:
     Input: [3,1,2,4]
     Step 1: compare 3 and 1. 3 > 1 => swap => [1,3,2,4]
     Step 2: Compare 3 and 2. 3 > 2 => swap => [1,2,3,4]
     Result: [1,2,3,4] => second greatest element has moved to its position(penultimate). 
                         Other elements have also fallen in place, which happened only because 
                         of the input combination we have.
     swapped = true
Iteration 3:
     Input: [1,2,3,4]
     Step 1: compare 1 and 2. 1 < 2 => no change => [1,2,3,4]
     Result: [1,2,3,4] => All elements have fallen in place.
     swapped = false
Since swapped flag is false, no more iterations are required.
Note: 
1)Step 3 is not performed in iteration 2, because we are certain that the greatest element 
has moved to the end at the end of iteration 1.
2) Step 2 and 3 are not performent in iteration 3, because we are certain that greatest(as a part
of iteration 1) and second greatest (as a part of iteration 2) have moved to their respective places.
Performance:
=========== 
As it can be seen from the above section, there are two loops in question
1) Inner loop 2) Outer loop
1) Inner loop: 
    Runs n times in the first iteration, n-1 times in the second iteration all the way upto 1 time 
in the last iteration. So 
n+(n-1)+.....+1
2) Outer loop:
    Runs n times in the worst case.
Total complexity:
   o(n *(n+(n-1)+(n-2)+...+1))
   o(n*n)
   o(n^2)
This is one of the least performing algorithms for sorting. The biggest draw back of this algorithm is
that it runs one extra iteration after sorting everything because it is unaware that everything is already
sorted.*/

var bubbleSort = function(arr){
   var swapped = true;
   while(swapped){
       swapped = false;
        for(let i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
                swapped = true;
                swap(arr,i,i+1)
            }
        }  
   }
   return arr;
};
var input = [50,40,1,20,11,6];
console.log(`bubble sorted = ${bubbleSort(input)}`);
