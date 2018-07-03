class Sorting{
  
  // Swap function
  private void swap(int[] arr, int i, int j) {
    temp = arr[i];
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

  // Quick sort

  public static void main(String[] args) {

    Sorting s = new Sorting();

    int[] arr = new int[]{2,1,3,4,6,5};
    s.bubbleSort(arr);

    int[] arr1 = new int[]{2,1,4,3,6,5};
    s.insertionSort(arr1);

    int[] arr2 = new int[]{2,1,4,3,6,5};
    s.selectionSort(arr2);
  }
}