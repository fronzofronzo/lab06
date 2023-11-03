package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N,Set<N>> graph;
    
    public GraphImpl() {
        this.graph = new HashMap<>();
    }

    public void addNode(N node) {
        if(!(node == null || graph.containsKey(node))) {
            this.graph.put(node, new HashSet<>());
        }
    }

    public void addEdge(N source, N target) {
        if(!(source == null || target == null)) {
            this.graph.get(source).add(target);
        }
    }

    public Set<N> nodeSet() {
        return this.graph.keySet();
    }

    public Set<N> linkedNodes(N node) {
        return this.graph.get(node);
    }

    public List<N> getPath(N source, N target) {
        final List<N> path = new ArrayList<>();
        final Queue<N> visited = new LinkedList<>();
        visited.add(source);
        N actual = source;
        while(!actual.equals(target)) {
            actual = visited.remove();
            path.add(actual);
            visited.addAll(graph.get(actual));
        }
        return path;
    }
}