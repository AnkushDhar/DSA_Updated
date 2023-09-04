package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
    static boolean isBipartite (ArrayList<Edge> [] graph) {
        int [] col = new int[graph.length];
        Arrays.fill(col, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { //BFS
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge edge = graph[curr].get(j);
                        if (col[edge.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[edge.dest] = nextCol;
                            q.add(edge.dest);
                        } else if (col[edge.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
