from typing import List
from collections import deque

class TreeNode:
    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None

class solution:
    def inorderTraversalRecursive(self, node:TreeNode)->List[int]:
        res=[]
        if not node:
            return res
        res.extend(self.inorderTraversalRecursive(node.left))
        res.append(node.val)
        res.extend(self.inorderTraversalRecursive(node.right))
        return res

    def inorderTraversalIterative(self, node:TreeNode)->List[int]:
        res=[]
        stack = deque()
        if not node:
            return res
        current = node
        while current != None or len(stack)!=0:
            if current:
                stack.append(current)
                current = current.left
            else:
                temp = stack.pop()
                res.append(temp.val)
                current = temp.right
        return  res
root = TreeNode(1)
two = TreeNode(2)
three = TreeNode(3)
four = TreeNode(4)
five = TreeNode(5)
six = TreeNode(6)

root.left = two
root.right = three
two.left = four
two.right = five
five.right= six

object = solution()
for item in object.inorderTraversalIterative(root):
    print(item)
print("Lets try recursion",end=" ")
for item in object.inorderTraversalRecursive(root):
    print(item, end=" ")
