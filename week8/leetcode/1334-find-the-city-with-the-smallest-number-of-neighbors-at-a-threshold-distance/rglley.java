class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                if (from == to) {
                    dist[from][to] = 0;
                } else {
                    dist[from][to] = Integer.MAX_VALUE / 2;
                }
            }
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }
        
        for (int middle = 0; middle < n; middle++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    if (dist[from][middle] + dist[middle][to] < dist[from][to]) {
                        dist[from][to] = dist[from][middle] + dist[middle][to];
                    }
                }
            }
        }
        
        int city = -1;
        int min = n;
        for (int from = 0; from < n; from++) {
            int count = 0;
            for (int to = 0; to < n; to++) {
                if (from != to && dist[from][to] <= distanceThreshold) {
                    count++;
                }
            }
            if (count < min) {
                min = count;
                city = from;
            } else if (count == min && from > city) {
                city = from;
            }
        }
        
        return city;
    }
}
