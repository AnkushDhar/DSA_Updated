package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingBFS {
    static class Edge {
        int src, dest;
        public Edge (int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph (ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    static void calcInDeg (ArrayList<Edge> [] graph, int [] inDeg) {
        for (ArrayList<Edge> edges : graph) {
            for (Edge edge : edges) {
                inDeg[edge.dest]++;
            }
        }
    }
    static void topSort (ArrayList<Edge> [] graph) {
        int []inDeg = new int[graph.length];
        calcInDeg(graph, inDeg);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            System.out.print(curr+" ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge edge = graph[curr].get(i);
                inDeg[edge.dest]--;
                if (inDeg[edge.dest] == 0) {
                    queue.add(edge.dest);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
