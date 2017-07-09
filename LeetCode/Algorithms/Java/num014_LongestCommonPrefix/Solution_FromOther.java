package num014_LongestCommonPrefix;

public class Solution_FromOther {
	public String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	}
}
/*
https://leetcode.com/problems/longest-common-prefix/#/description
Write a function to find the longest common prefix string amongst an array of strings.
*/
//From https://discuss.leetcode.com/topic/6987/java-code-with-13-lines
//Author https://discuss.leetcode.com/user/desmile
