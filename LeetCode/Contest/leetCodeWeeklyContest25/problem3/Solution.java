package leetCodeWeeklyContest25.problem3;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    List<Integer> left = new LinkedList<>(), mid = new LinkedList<>(), right = new LinkedList<>();
	    preorder(root, left, mid, right, 0);
	    left.addAll(mid);
	    left.addAll(right);
	    return left;
	}

	public void preorder(TreeNode cur, List<Integer> left, List<Integer> mid, List<Integer> right, int flag) {
	    if (cur == null) return;
	    if (flag <= 1) left.add(cur.val);
	    else if (flag == 2) right.add(0, cur.val);
	    else if (cur.left == null && cur.right == null) mid.add(cur.val);
	    preorder(cur.left, left, mid, right, flag <= 1 ? 1 : (flag == 2 && cur.right == null) ? 2 : 3);
	    preorder(cur.right, left, mid, right, flag % 2 == 0 ? 2 : (flag == 1 && cur.left == null) ? 1 : 3);
	}
}
//https://leetcode.com/contest/leetcode-weekly-contest-25/problems/boundary-of-binary-tree/
/*
545. Boundary of Binary Tree My SubmissionsBack To Contest
User Accepted: 528
User Tried: 758
Total Accepted: 539
Total Submissions: 2536
Difficulty: Medium
Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
*/
//From https://discuss.leetcode.com/topic/84258/java-preorder-single-pass-o-n-solution
//Author https://discuss.leetcode.com/user/compton_scatter
