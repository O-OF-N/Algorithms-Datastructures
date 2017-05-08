a = [1,2,3,4,6,7];

const binarySearch = (array,value) =>{
  const binarySearchIterate = (array,startIndex,endIndex,value)=>{
    if(startIndex>endIndex) return null;
    const mid = startIndex+Math.floor((endIndex-startIndex)/2);
    if(array[mid] === value) 
      return mid;
    else if(array[mid]<value) 
      return binarySearchIterate(array,mid+1,endIndex,value);
    else 
      return binarySearchIterate(array,0,mid,value);
  };
  return binarySearchIterate(array,0,array.length-1,value);
}

binarySearch(a,10);
