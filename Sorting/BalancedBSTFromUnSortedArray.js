class Node{
	constructor(data,left,right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}
}

const quickSort = (arr) =>{
	if(arr.length<1) return [];
	const left =[], right =[];
	const pivot = arr[0];
	for(let i=1;i<arr.length;i++){
		if(arr[i]<=pivot) left.push(arr[i]);
		if(arr[i]>pivot) right.push(arr[i]);
	}	
	return quickSort(left).concat(pivot,quickSort(right));
};



const constructBalancedBST = (arr)=>{
    if(arr.length<1) return null;
    if(arr.length==1) return arr[0];
	const mid = Math.round(arr.length/2);
	const data = arr[mid];
	const root = new Node(data,null,null);
	root.left = constructBalancedBST(arr.slice(0,mid));
	root.right = constructBalancedBST(arr.slice(mid+1,arr.length));
	return root;
};

const balancedSearchTreeFromUnsortedArray = (arr)=>{
	const sorted = quickSort(arr);
	const balancedBST = constructBalancedBST(sorted,0,sorted.length-1);
	console.log(balancedBST);
};

balancedSearchTreeFromUnsortedArray([4,3,2,1]);
