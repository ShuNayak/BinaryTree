# A mother vertex is a vertex from where all the other vertices can be visited.
# strongly connected components help us find the mother vertex , the start vertex in the component of the subgraph
from collections import defaultdict
class Graph:
    def __init__(self, vertices:int):
        self.v = vertices
        self.adjList = defaultdict(list)

    def addEdges(self, src:int, dest:int):
        self.adjList[src].append(dest)

    def DFS(self, vertex:int, visited:list):
        visited[vertex]= True
        for i in self.adjList[vertex]:
            if visited[i]==False:
                self.DFS(i,visited)

    def motherVertex(self):
        visited = [False]*self.v
        ans = 0
        for i in range(self.v):
            if visited[i] ==False:
                self.DFS(i, visited)
                ans = i

        # resetting visited to be false, jus to check if we are able to reach all vertices from mother vertex
        visited = [False]*self.v
        self.DFS(ans, visited)
        if any(i== False for i in visited):
            return -1
        return ans
obj = Graph(4)
obj.addEdges(0,1)
obj.addEdges(1,3)
obj.addEdges(3,0)
obj.addEdges(1,0)
obj.addEdges(1,2)
print( 'All the mother vertices')
ans = obj.motherVertex()
print(ans)
# if we want to find all the mother vertices then find the vertices that have an outgoing edge to the mother vertex output
for vertex, subList in obj.adjList.items():
    if vertex==ans:
        pass
    else:
        if ans in subList:
            print(vertex)





