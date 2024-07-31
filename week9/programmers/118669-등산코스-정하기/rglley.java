import java.util.*;

class Solution {
    static List<List<Node>> graph;
  
    static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> qu = new LinkedList<>();
        int[] intensity = new int[n + 1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            qu.add(new Node(gate, 0));
            intensity[gate] = 0; 
        }

        while (!qu.isEmpty()) {
            Node currentNode = qu.poll();

            if (currentNode.intensity > intensity[currentNode.node]) 
                continue;

            for (int nodeIdx = 0; nodeIdx < graph.get(currentNode.node).size(); nodeIdx++) {
                Node nextNode = graph.get(currentNode.node).get(nodeIdx);

                // 최소 갱신
                int distance = Math.max(intensity[currentNode.node], nextNode.intensity);
                if (intensity[nextNode.node] > distance) {
                    intensity[nextNode.node] = distance;
                    qu.add(new Node(nextNode.node, distance));
                }
            }
        }

        int mountain = Integer.MAX_VALUE; // 산봉우리 번호
        int answer = Integer.MAX_VALUE; // 최솟값
        
        
        Arrays.sort(summits);   //작은 산봉우리부터 탐색

        for (int summit : summits) {
            if (intensity[summit] < answer) {
                mountain = summit;
                answer = intensity[summit];
            }
        }

        return new int[]{mountain, answer};
    }
    
    static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }
    
    static boolean isSummit(int num, int[] summits) {
        for (int summit : summits) {
            if (num == summit) return true;
        }
        return false;
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int node = 0; node <= n; node++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int intensity = path[2];

            // 출입구일 경우 다른 곳으로만 갈 수 있는 단방향
            // 산봉우리일 경우 특정 한 곳에서 산봉우리로 가는 단방향
            if (isGate(from, gates) || isSummit(to, summits)) {
                graph.get(from).add(new Node(to, intensity));
            } else if (isGate(to, gates) || isSummit(from, summits)) {
                graph.get(to).add(new Node(from, intensity));
            } else {
                // 일반 등산로일 경우 양방향
                graph.get(from).add(new Node(to, intensity));
                graph.get(to).add(new Node(from, intensity));
            }
        }
        
        return dijkstra(n, gates, summits);
    }
}

class Node {
    int node; 
    int intensity;

    Node(int node, int intensity) {
        this.node = node;
        this.intensity = intensity;
    }
}
