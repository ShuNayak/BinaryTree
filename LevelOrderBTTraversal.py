from typing import List
class TreeNode:
    def __init__(self, val=0, left= None, right=None):
        self.val = val
        self.left = left
        self.right = right

class solution:
    def levelOrderTraversal(self, node:TreeNode)->List[List[int]]:
        ans, level =[], [node]
        while node and level:
            ans.append([item.val for item in level])
            level = [child for n in level for child in (n.left, n.right) if child]
        return ans

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
obj = solution()
print(obj.levelOrderTraversal(root))


