'use strict';
//Simple ol' school swap function  
var swap = function(arr,pos1,pos2){
    let temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
    return arr;
}

/* Merge Sort: 
To be filled */

const MergeSort = a =>{
  if(a.length<2) return a;
  const mid = parseInt(a.length/2);
  const left = a.slice(0,mid);
  const right = a.slice(mid,a.length);
  return merge(MergeSort(left),MergeSort(right));
};
const merge = (left,right)=>{
  const output = [];
  while(left.length && right.length){
    if(left[0]<right[0])
      output.push(left.shift());
    else
      output.push(right.shift());
  }
  while(left.length)
    output.push(left.shift());
  while(right.length)
    output.push(right.shift());    
  return output;
}

/* Quick Sort:

To be filled */

const QuickSort = a =>sort(a,0,a.length-1);

const sort = (a,low,high) =>{
  if(low>=high) return a;
  const wall = partition(a,low,high);
  sort(a,low,wall-1);
  sort(a,wall+1,high);
  return a;
}

const partition = (a,low,high)=>{
  let wall = low;
  swap(a,low,high);
  for(let i=low+1;i<=high;i++){
    if(a[i]<a[wall]){
      swap(a,i,wall);
      swap(a,i,wall+1);
      wall++;
    }
  }
  return wall;
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
const selectionSort = a=>{
  let pos = 0;
  while(pos<a.length-1){
    let min = -1;
    let minPos = -1;
    for(let i=pos;i<a.length;i++){
      if(min === -1 || a[i]<min){
        min = a[i];
        minPos = i;
      }
    }
    swap(a,minPos,pos);
    pos++;
  }
  return a;
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

const insertionSort = a =>{
  let pos =0;
  while(pos<a.length){
    const val = a[pos];
    let curr = pos;
    for(let i=pos; i>-1;i--){
      if(val < a[i]){
        swap(a,curr,i);
        curr = i;
      }
    }
    pos++;
  }
  return a;
}
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

const bubbleSort = a=>{
  let modified = true;
  while(modified){
    modified = false;
    for(let i =0;i<a.length-1;i++){
      if(a[i]>a[i+1]) {
        swap(a,i,i+1);
        modified = true;
      }
    }
  }
  return a;
};
var input = [50,40,1,20,11,6];
console.log(`bubble sorted = ${bubbleSort(input)}`);
