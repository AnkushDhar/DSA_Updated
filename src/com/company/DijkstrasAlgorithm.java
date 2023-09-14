package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static void createGraph (ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair (int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo (Pair p2) {
            return this.path - p2.path; // path based sorting for my pairs
        }
    }
    static void dijkstra (ArrayList<Edge> [] graph, int src) {
        int [] dist = new int[graph.length]; // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean [] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge edge = graph[curr.n].get(i);
                    int u = edge.src;
                    int v = edge.dest;
                    int wt = edge.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int j : dist) {
            System.out.print(j+" ");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);
    }
}
