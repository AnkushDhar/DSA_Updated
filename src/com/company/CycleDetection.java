package com.company;

import java.util.ArrayList;

public class CycleDetection {
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
    static boolean detectCycle (ArrayList<Edge> [] graph) {
        boolean [] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean detectCycleUtil (ArrayList<Edge> [] graph, boolean [] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            
            //case 3:
            if (!vis[edge.dest]) {
                if (detectCycleUtil(graph, vis, edge.dest, curr)) {
                    return true;
                }
            } else if (vis[edge.dest] && edge.dest != par) { //case 1:
                return true;
            }
            //case 2: do nothing -> continue
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
