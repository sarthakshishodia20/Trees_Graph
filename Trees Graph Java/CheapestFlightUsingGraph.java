import java.util.*;

public class CheapestFlightUsingGraph {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph, int[][] flight) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        public Info(int v, int cost, int stop) {
            this.v = v;
            this.cost = cost;
            this.stop = stop;
        }
    }

    public static int cheapestRoute(int n, int src, int dest, int k, int[][] flight) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flight);
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; 

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k) {
                continue; 
            }
            for (Edge e : graph[curr.v]) {
                int v = e.dest;
                int wt = e.wt;
                if (curr.cost + wt < dist[v]) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1; 
        } else {
            return dist[dest]; 
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] flight = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        int ans = cheapestRoute(V, src, dest, k, flight);
        System.out.println(ans);
    }
}
