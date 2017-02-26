const binarySearch = (arr,val)=>{
	if(arr.length<1) return false;
	if(arr.length === 1){
		if(val === arr[0]) return true;
		else return false;
	} 
	const mid = Math.floor(arr.length/2);
	const midVal = arr[mid];
	return (midVal === val)? true:(val < midVal)?binarySearch(arr.slice(0,mid),val): binarySearch(arr.slice(mid),val);
}

