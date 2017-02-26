const binarySearch = (arr,val)=>{
	if(arr.length<1) return null;
	const mid = Math.floor(arr.length/2);
	const midVal = arr[mid];
	return (midVal === val)? val:(val < midVal)?binarySearch(arr.slice(0,mid),val): binarySearch(arr.slice(mid),val);
}
