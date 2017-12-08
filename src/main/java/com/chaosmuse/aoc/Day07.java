package com.chaosmuse.aoc;

import com.sun.deploy.util.StringUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class Day07 {

    public String partTwo(String input) throws NoSuchMethodException {
        // TODO
        throw new NoSuchMethodException(input);
    }

    public String partOne(String input) {

        Map<String, String[]> nodes = buildNodes(input);
        WeightedTree<String> nodeTree = buildTreeFromNodes(nodes);

        if (nodeTree != null && nodeTree.getNode() != null) {
            return nodeTree.getNode();
        } else {
            return "Could not build tree structure.";
        }
    }

    /**
     * TreeSet is ordered as such - each element E is a Map containing a 'name' key and a 'weight' value.
     *
     * @param nodes
     * @return
     */
    private WeightedTree<String> buildTreeFromNodes(Map<String, String[]> nodes) {
        List<WeightedTree<String>> orphanedNodes = new ArrayList<>();
        for (Map.Entry<String, String[]> node : nodes.entrySet()) {
            int weight = Integer.parseInt(node.getValue()[0]);
            WeightedTree<String> nodeTree = new WeightedTree<>(node.getKey(), weight);
            System.out.println("New node: " + nodeTree.getNode() + " - " + StringUtils.join(Arrays.asList(node.getValue()), ","));

            if (node.getValue().length > 1) {
                List<String> children = new ArrayList<>();
                for (int i = 0; i < node.getValue().length - 1; i++) {
                    children.add(node.getValue()[i + 1]);
                }

                // add orphans to current tree head
                for (WeightedTree<String> orphan : orphanedNodes) {
                    System.out.println("\tLooking for " + orphan.getNode() + " in children");
                    if (children.contains(orphan.getNode())) {
                        nodeTree.addChild(orphan);
                        System.out.println("\t\t--> Found");
                    }
                }
            }

            // remove added children from orphan list
            if (CollectionUtils.isNotEmpty(nodeTree.getChildren())) {
                orphanedNodes.removeAll(nodeTree.getChildren());
                System.out.println("\tRemoved children from orphans list");
            }
            // make the current collection of non-orphaned nodes a new entry
            orphanedNodes.add(nodeTree);
        }


        // should be down to a single item
        assert orphanedNodes.size() == 1;

        return orphanedNodes.get(0);
    }

    private Map<String, String[]> buildNodes(String input) {
        Map<String, String[]> nodes = new HashMap<>();
        for (String rawNode : input.split("\n")) {
            String[] splitRawNode = rawNode.split("[()\\->, ]+");
            String[] nodeValue = new String[splitRawNode.length - 1];
            for (int i = 0; i < splitRawNode.length - 1; i++) {
                nodeValue[i] = splitRawNode[i + 1];
            }
            nodes.put(splitRawNode[0], nodeValue);
            // System.out.println("Key: " + splitRawNode[0] + "; " + StringUtils.join(Arrays.asList(nodeValue), ","));
        }

        return nodes;
    }

    class WeightedTree<T> {
        private final T node;
        private final int weight;
        private ArrayList<WeightedTree<T>> children;

        public WeightedTree(T node, int weight) {
            this.node = node;
            this.weight = weight;
            children = new ArrayList<>();
        }

        public T getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }

        public ArrayList<WeightedTree<T>> getChildren() {
            return children;
        }

        public void addChild(WeightedTree<T> child) {
            children.add(child);
        }
    }
}
