package leetCodeWeeklyContest40.problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class Solution_FromOther {
	public List<Double> averageOfLevels(TreeNode root) {
	    List<Double> result = new ArrayList<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    
	    if(root == null) return result;
	    q.add(root);
	    while(!q.isEmpty()) {
	        int n = q.size();
	        double sum = 0.0;
	        for(int i = 0; i < n; i++) {
	            TreeNode node = q.poll();
	            sum += node.val;
	            if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
	        }
	        result.add(sum / n);
	    }
	    return result;
	}
}
/*
https://leetcode.com/contest/leetcode-weekly-contest-40/problems/average-of-levels-in-binary-tree/
637. Average of Levels in Binary Tree My SubmissionsBack to Contest
User Accepted: 1338
User Tried: 1396
Total Accepted: 1366
Total Submissions: 2177
Difficulty: Easy
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
/*
From https://discuss.leetcode.com/topic/95214/java-bfs-solution
Author https://discuss.leetcode.com/user/jaqenhgar
*/
//PracticedOn20170708Sat 5Times