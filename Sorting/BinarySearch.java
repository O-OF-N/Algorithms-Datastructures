class BinarySearch {
  private static int binarySearch(int[] arr, int find, int l, int r){
    if(r<l) return -1;
    int mid = l+(r-l)/2;
    if(arr[mid] == find) return find;
    else if(arr[mid] > find) return binarySearch(arr, find, l, mid-1);
    else return binarySearch(arr, find, mid+1, r);
  }

  
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5,6};
    int find = 3;
    int result = binarySearch(arr, find, 0, arr.length-1);
    System.out.println("result = " + result);
  }
}