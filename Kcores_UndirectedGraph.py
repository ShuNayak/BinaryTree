from collections import defaultdict

class Graph:
    def __init__(self, vertices:int, kcore:int):
        self.k=kcore
        self.V= vertices
        self.graph=defaultdict(list)

    def addEdge(self, src:int, dst:int):
        #undirected graph
        self.graph[src].append(dst)
        self.graph[dst].append(src)

    def DFSUtil(self, kCore:int, visited, startVertex, vDegree )->bool:
        visited[startVertex]= True

        for i in self.graph[startVertex]:
            if vDegree[startVertex]<kCore:
                vDegree[i]-=1
                vDegree[startVertex]-=1


            if visited[i]==False:
                if(self.DFSUtil(kCore, visited, i, vDegree)):
                    vDegree[startVertex]-=1
                    vDegree[i]-=1

        return vDegree[startVertex]<kCore

    def findKcore(self):
        visited = [False]*self.V
        vDegree = [0]*self.V

        for i in range(self.V):
            vDegree[i]= len(self.graph[i])


        self.DFSUtil(self.k, visited, 0, vDegree)

        for i in range(self.V):
            if vDegree[i]>=self.k:
                print (str("\n[") + str(i)+str("]"))
                for j in self.graph[i]:
                    if vDegree[j]>=self.k:
                        print(str("->")+str(j))

obj = Graph(6,2)
obj.addEdge(0,1)
obj.addEdge(1,5)
obj.addEdge(1,2)
obj.addEdge(2,4)
obj.addEdge(2,3)
obj.addEdge(3,4)

obj.findKcore()


