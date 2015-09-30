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
sorted.
*/
/*Code:
  ===== */
//Method that performs bubble sort  
def bubbleSort(int[] input){
   //a flag that is set to true even if a single swap is done.
   // we set this to true initially to get into the loop.
   //Conversely can be implemented using a do..while loop.
   boolean swap = true 
   
   //denotes the current iteration count.This is used to prevent successive
   //iterations from iterating over already sorted elements.
   int itr = 0
   
   //Iteration runs as long as a single swap operation is performed.
   while(swap) {
       //Start the iteration with swap as false
       swap = false
       
       //Iterating over the elements in the array
        for(int i =0; i<input.length-1-itr; i++){
           //Used to sort in descending order 
           if(input[i]< input[i+1]){
               //swapped.so flip the flag
               swap = true
               
               //swap operation
               int temp = input[i+1]
               input[i+1] = input[i]
               input[i]=temp
            } 
        }
        //Increases the iteration count
        itr++
    }
    //returns sorted array
    input
}
bubbleSort([2,1,3,100,4,21,88,10,10] as int[])   
