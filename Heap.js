'use strict';

class MinHeap {
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
        this.removeElementFromPos(elementPos);
    };

    removeMinElement() {
        this.removeElementFromPos(0);
    }

    removeElementFromPos(elementPos) {
        const lastChild = (this.heap.length > 0) ? this.heap.length - 1 : undefined;
        if (lastChild != undefined) {
            this.removeAndSwap(this.heap, elementPos, lastChild);
            let childPos = undefined;
            let currentPos = elementPos;
            do {
                let rChild = this.findRightChildPos(currentPos);
                let lChild = this.findLeftChildPos(currentPos);

                if (rChild != undefined && lChild != undefined) {
                    childPos = (this.heap[lChild] > this.heap[rChild]) ? rChild : lChild;
                } else if (lChild != undefined) {
                    childPos = lChild;
                } else childPos = undefined;
                if (childPos != undefined &&
                    this.heap[currentPos] > this.heap[childPos]) {
                    this.swap(this.heap, childPos, currentPos);
                    currentPos = childPos;
                } else childPos = undefined;
            } while (childPos != undefined);
        }
    }

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

    findElementPos(element) {
        var pos = -1;
        this.heap.forEach((x, i) => (x == element) ? pos = i : pos);
        return pos;
    };

    get Heap() {
        return this.heap;
    }
};

class MaxHeap {
    constructor() {
        this.heap = [];
    };

    addElement(element) {
        this.heap.push(element);
        let elementPos = this.heap.length - 1;
        let parentPos = this.findParentPos(elementPos);
        while (element > this.heap[parentPos]) {
            this.swap(this.heap, parentPos, elementPos);
            elementPos = parentPos;
            let parentPosTemp = this.findParentPos(elementPos);
            parentPos = (parentPosTemp != undefined) ? parentPosTemp : elementPos;
        }
    };

    removeElement(element) {
        const elementPos = this.findElementPos(element);
        this.removeElementFromPos(elementPos);
    };

    removeMinElement() {
        this.removeElementFromPos(0);
    }

    removeElementFromPos(elementPos) {
        const lastChild = (this.heap.length > 0) ? this.heap.length - 1 : undefined;
        if (lastChild != undefined) {
            this.removeAndSwap(this.heap, elementPos, lastChild);
            let childPos = undefined;
            let currentPos = elementPos;
            do {
                let rChild = this.findRightChildPos(currentPos);
                let lChild = this.findLeftChildPos(currentPos);

                if (rChild != undefined && lChild != undefined) {
                    childPos = (this.heap[lChild] < this.heap[rChild]) ? rChild : lChild;
                } else if (lChild != undefined) {
                    childPos = lChild;
                } else childPos = undefined;
                if (childPos != undefined &&
                    this.heap[currentPos] < this.heap[childPos]) {
                    this.swap(this.heap, childPos, currentPos);
                    currentPos = childPos;
                } else childPos = undefined;
            } while (childPos != undefined);
        }
    }

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

    findElementPos(element) {
        var pos = -1;
        this.heap.forEach((x, i) => (x == element) ? pos = i : pos);
        return pos;
    };

    get Heap() {
        return this.heap;
    }
};
