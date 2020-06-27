/*
Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

class Solution {
    public int numSquares(int n) {
        
        int[] arr = new int[n+1];
        return numS(n,arr);
        
    }
    
    public int numS(int n,int[] arr)
    {
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;
        if(arr[n] > 0) return arr[n];
        
        int min = n;
        for(int i=1;i*i<=n;i++)
            min = Math.min(numS(n-(i*i),arr),min);
        
        arr[n] = min+1;
        return min+1;
    }
}
