# finding the transitive closure i.e path from vertex v to u for every pair of vertices (v,u) in the graph
from collections import defaultdict
from typing import List

class Graph:
    def __init__(self, vertices:int):
        self.graph = defaultdict(list)
        self.V = vertices
        self.ans  = [[0 for i in range(self.V)] for j in range(self.V)]

    def addEdge(self, start:int, dest:int):
        self.graph[start].append(dest)

    def DFS(self, src:int, dst:int):
        self.ans[src][dst]=1
        for i in self.graph[dst]:
            if self.ans[src][i]==0:
                self.DFS(src, i)

    def transitiveClosure(self):
        for i in range(self.V):
            self.DFS(i,i)
        print(self.ans)

obj = Graph(5)
obj.addEdge(0,1)
obj.addEdge(1,2)
obj.addEdge(2,0)
obj.addEdge(2,3)
obj.addEdge(2,4)
obj.addEdge(3,2)
obj.addEdge(4,0)

obj.transitiveClosure()


