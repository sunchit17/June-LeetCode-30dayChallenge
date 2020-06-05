/*
Given an array w of positive integers, where w[i] describes the weight of index i,
write a function pickIndex which randomly picks an index in proportion to its weight.

Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments.
Solution's constructor has one argument, the array w. pickIndex has no arguments.
Arguments are always wrapped with a list, even if there aren't any.
*/


class Solution {
    
    Random rand;
    int[] cumulative_w;
        
    public Solution(int[] w) {
        
        this.rand = new Random();
        this.cumulative_w = w.clone();
        for(int i=1;i<cumulative_w.length;i++)
            cumulative_w[i] += cumulative_w[i-1];
        
       /* for(int i=0;i<cumulative_w.length;i++)
             System.out.print(cumulative_w[i]+" "); */
        
    }
    
    public int pickIndex() {
        
        int pick =  rand.nextInt(cumulative_w[cumulative_w.length-1])+1;
        int left = 0;
        int right = cumulative_w.length-1;
        
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(cumulative_w[mid]<pick)
                left = mid+1;
            else if(cumulative_w[mid]>pick)
                right = mid-1;
            else
                return mid;
        }
        
        return left;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
