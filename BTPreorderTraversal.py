
from typing import List
from collections import deque
class TreeNode:
    def __init__(self,x):
        self.data = x
        self.left = None
        self.right = None

class solution:
    def preorderTraversalRecursive(self,node:TreeNode)->List[int]:
        res = []
        if not node:
            return res
        res.append(node.data)
        res.extend(self.preorderTraversalRecursive(node.left))
        res.extend(self.preorderTraversalRecursive(node.right))
        return res
    def preorderTraversalIterative(self,node:TreeNode)->List[int]:
        stack =deque()
        res =[]
        if not node:
            return res
        stack.append(node)
        while stack:
            val = stack.pop()
            res.append(val.data)

            if val.right:
                stack.append(val.right)
            if val.left:
                stack.append(val.left)
        return res





root = TreeNode(1)
two = TreeNode(2)
three = TreeNode(3)
four = TreeNode(4)
five = TreeNode(5)
root.left = two
root.right = three
two.left = four
four.left = five

object = solution()
myList = object.preorderTraversalRecursive(root)
for i in myList:
    print(i,end=" ")

print("iterative using stack")
myArr = object.preorderTraversalIterative(root)
for i in myArr:
    print(i,end=" ")

