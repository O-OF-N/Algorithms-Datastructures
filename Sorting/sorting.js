'use strict';
//Simple ol' school swap function  
var swap = function(arr,pos1,pos2){
    let temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
    return arr;
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
