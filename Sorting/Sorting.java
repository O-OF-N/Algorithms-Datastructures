import java.util.Arrays;

class Sorting{
  
  // Swap function
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Bubble Sort
  private void bubbleSort(int[] arr) {
    boolean modified =  false;

    while(modified){
      modified = false;
      System.out.println(Arrays.toString(arr));
      for(int i=0; i<arr.length-1; i++){
        if(arr[i] > arr[i+1]) {
          swap(arr, i, i+1);
          modified = true;
        }
      }
    }
  }


  // Insertion sort
  private void insertionSort(int[] arr) {
    int wall = 0;
    while(wall < arr.length-1){
      int pos = wall + 1;
      int curr = arr[pos];
      for(int i=wall;i>-1;i--){
        if(curr<arr[i]) {
          swap(arr, pos, i);
          pos = i;
        } else break;
      }
      wall++;
    }
  }

  // Selection sort

  private void selectionSort(int[] arr) {
    int wall = 0;
    while(wall<arr.length){
      int min  = Integer.MAX_VALUE;
      int minPos = -1;
      for(int i= wall; i < arr.length; i++){
        if(arr[i] < min) {
          min = arr[i];
          minPos = i;
        }
      }
      swap(arr, minPos, wall);
      wall++;
    }
  }

  // Merge sort

  private void mergeSort(int[] arr) {
    partition(arr, 0, arr.length-1);
  }

  private void partition(int[] arr, int start, int end) {
    if(start == end) return;
    int mid = start+ (end-start)/2;
    partition(arr, start, mid);
    partition(arr, mid+1, end);
    merge(arr, start, end);
  }

  private void merge(int[] arr, int start, int end) {
    int[] target = new int[arr.length];
    int leftStart = start;
    int leftEnd = leftStart+ (end-start)/2;
    int rightStart = leftEnd+1;
    int rightEnd = end;
    int index = start;
    while(leftStart <= leftEnd && rightStart <= rightEnd) {
      if(arr[leftStart] <arr[rightStart]){
        target[index++] = arr[leftStart++];
      } else {
        target[index++] = arr[rightStart++];
      }
    }
    while(leftStart<=leftEnd) target[index++] = arr[leftStart++];
    while(rightStart<=rightEnd) target[index++] = arr[rightStart++];

    for(int i= start;i<=end;i++) arr[i] = target[i];
  }


  // Main

  public static void main(String[] args) {

    Sorting s = new Sorting();

    int[] arr = new int[]{2,1,3,4,6,5};
    System.out.println("Bubble sort input = " + Arrays.toString(arr));
    s.bubbleSort(arr);
    System.out.println("Bubble sort output = " + Arrays.toString(arr));

    int[] arr1 = new int[]{2,1,4,3,6,5};
    System.out.println("Insertion sort input = " + Arrays.toString(arr1));
    s.insertionSort(arr1);
    System.out.println("Insertion sort output = " + Arrays.toString(arr1));

    int[] arr2 = new int[]{2,1,4,3,6,5};
    System.out.println("Selection sort input = " + Arrays.toString(arr2));
    s.selectionSort(arr2);
    System.out.println("Selection sort output = " + Arrays.toString(arr2));

    int[] arr3 = new int[]{2,1,4,3,6,5};
    System.out.println("Merge sort input = " + Arrays.toString(arr3));
    s.mergeSort(arr3);
    System.out.println("Merge sort output = " + Arrays.toString(arr3));
  }
}