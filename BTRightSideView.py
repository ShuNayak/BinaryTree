from typing import  List
class TreeNode:
    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        ans, levels = [], [root]
        while root and levels:
            ans.append(levels[-1].val)
            levels = [child for n in levels for child in (n.left, n.right) if child]
        return ans

obj = Solution()
root = TreeNode(1)
two = TreeNode(2)
three = TreeNode(3)
four = TreeNode(4)
six = TreeNode(6)
five = TreeNode(5)
seven = TreeNode(7)

root.left = two
root.right = three
two.left = six
three.left = four
three.right = five
six.left = seven

print(obj.rightSideView(root))
