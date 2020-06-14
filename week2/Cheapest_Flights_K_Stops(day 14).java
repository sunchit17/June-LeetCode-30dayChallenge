/*
There are n cities connected by m flights.
Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, 
together with starting city src and the destination dst,
your task is to find the cheapest price from src to dst with up to k stops.
If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1

Output: 200
The cheapest price from city 0 to city 2 with at most 1 stop costs 200.

Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0

Output: 500
The cheapest price from city 0 to city 2 with at most 0 stop costs 500
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
            map.put(i,new HashMap<>());
        
        for(int[] f:flights)
            map.get(f[0]).put(f[1],f[2]);
        
        Queue<int[]> priority = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        priority.add(new int[]{0,src,-1});
        
        while(!priority.isEmpty())
        {
            int[] ff = priority.poll();
            int fare = ff[0], dest = ff[1], stop = ff[2];
            if(dest == dst) return fare;
            if(stop < K)
            {
                Map<Integer,Integer> temp = map.getOrDefault(dest,new HashMap<>());
                for(int cc : temp.keySet())
                {
                    priority.add(new int[]{fare+temp.get(cc),cc,stop+1});
                }
            }
        }
        return -1;
    }
}
