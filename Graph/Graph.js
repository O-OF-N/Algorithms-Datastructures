class Graph{
  constructor(nodes){
    this.nodes = nodes;
    this.initializeConnection(nodes);
  }
  initializeConnection(nodes){
    this.connections = [];
    nodes.forEach(n1=>{
      this.connections.push(new Array(nodes.length).fill(0))
    });
  }
  addConnection(from,to,bi){
    this.connections[from][to]=1;
    if(bi){
      this.connections[to][from]=1;
    }
  }
  dfs(node){
    const search=(node,visited)=>{
      const connections = this.connections[node];
      for(let i=0;i<connections.length;i++){
        if(!visited.has(i) && connections[i]>0){
          visited = visited.add(i);
          search(i,visited);
        }
      }
      console.log(node+'->');
    }
    search(node,new Set());
  }
  bfs(node){
    const visited = new Set();
    const connections = [];
    for(let i=0;i<this.connections[node].length;i++){
      if(this.connections[node][i]===1){
          connections.push(i);
        }
    }
    while(connections.length){
      const conn = connections.shift();
      console.log(conn);
      visited.add(conn);
      const connConnections = this.connections[conn];
      for(let i=0;i<connConnections.length;i++){
        if(!visited.has(i) && connConnections[i]===1){
          connections.push(i);
        }
      }
    }
  }
}
const g = new Graph([0,1,2,3,4,5]);
g.addConnection(0,1,true);
g.addConnection(1,2,true);
g.addConnection(2,3,true);
g.addConnection(3,4,true);
g.addConnection(4,5,true);
g.addConnection(5,1,false);
console.log('graph =', g);
console.log('DFS>>>>>>>');
g.dfs(0);
console.log('BFS>>>>>>>');
g.bfs(0);
