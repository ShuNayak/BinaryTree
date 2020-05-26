from collections import deque

class TreeNode:
    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        stk = deque([])
        stk.append(root)

        while stk:
            tempNode = stk.pop()

            if tempNode.right:
                stk.append(tempNode.right)
            if tempNode.left:
                stk.append(tempNode.left)

            if stk:
                tempNode.right = stk[-1]
            tempNode.left = None