'use strict';

class Heap {
    constructor() {
        this.heap = [];
    };

    addElement(element) {
        this.heap.push(element);
        let elementPos = this.heap.length - 1;
        let parentPos = this.findParentPos(elementPos);
        while (element < this.heap[parentPos]) {
            this.swap(this.heap, parentPos, elementPos);
            elementPos = parentPos;
            let parentPosTemp = this.findParentPos(elementPos);
            parentPos = (parentPosTemp != undefined) ? parentPosTemp : elementPos;
        }
    };

    removeElement(element) {
        const elementPos = this.findElementPos(element);
        const rightMostChild = (elementPos) ? this.findRightMostChildPos(elementPos) :
            this.findRightMostChildPos(0);
        this.removeAndSwap(this.heap, elementPos, rightMostChild);
        let childPos = undefined;
        let currentPos = elementPos;
        do {
            let rChild = this.findRightChildPos(currentPos);
            let lChild = this.findLeftChildPos(currentPos);
            if (rChild != undefined && lChild != undefined) {
                childPos = (this.heap[lChild] > this.heap[rChild]) ? rChild : lChild;
                this.swap(this.heap, childPos, currentPos);
                currentPos = childPos;
            } else childPos = undefined;
        } while (childPos != undefined);
    };

    swap(array, pos1, pos2) {
        let temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
        return array;
    };

    removeAndSwap(array, removePos, replacementPos) {
        array[removePos] = array[replacementPos];
        return array.splice(replacementPos, 1);
    };

    findParentPos(pos) {
        return Math.floor((pos - 1) / 2);
    };
    findLeftChildPos(pos) {
        const parentPos = 2 * pos + 1;
        return (this.heap.length > parentPos) ? parentPos : undefined;
    };

    findRightChildPos(pos) {
        const parentPos = 2 * pos + 2;
        return (this.heap.length > parentPos) ? parentPos : undefined;
    };

    findRightMostChildPos(pos) {
        let childPos = pos;
        while (pos != undefined) {
            pos = this.findRightChildPos(childPos);
            childPos = (pos != undefined) ? pos : childPos;
        }
        return childPos;
    };

    findElementPos(element) {
        var pos = -1;
        this.heap.forEach((x, i) => (x == element) ? pos = i : pos);
        return pos;
    };

    get Heap() {
        return this.heap;
    }
};

let h1 = new Heap();
h1.addElement(5);
console.log(h1.Heap);

h1.addElement(1);
h1.addElement(7);
h1.addElement(2);
h1.addElement(3);
h1.addElement(10);
h1.addElement(4);
console.log(h1.Heap);


h1.removeElement(1);

console.log(h1.Heap);

