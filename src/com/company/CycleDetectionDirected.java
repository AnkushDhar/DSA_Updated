package com.company;

import java.util.ArrayList;

public class CycleDetectionDirected {
    static class Edge {
        int src, dest;
        public Edge (int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph (ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));
    }
    static boolean isCycle (ArrayList<Edge> [] graph) {
        boolean [] vis = new boolean[graph.length];
        boolean [] stack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil (graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isCycleUtil (ArrayList<Edge> [] graph, int curr, boolean [] vis, boolean [] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if (stack[edge.dest]) {
                return true;
            }
            if (!vis[edge.dest] && isCycleUtil(graph, edge.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
