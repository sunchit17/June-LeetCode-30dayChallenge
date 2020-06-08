/*
Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true 
Explanation: 2^0 = 1

Example 2:
Input: 16
Output: true
Explanation: 2^4 = 16

Example 3:
Input: 218
Output: false
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n==1 || n==2)
            return true;
        if(n%2!=0)
            return false;
        
        int num=n/2;
        
        for(int i=2;i<=num;i*=2)
        {
            if(n==i*2)
            {
                return true;
            }
        }
        
        return false;
        
    }
}
