package com.chaosmuse.aoc;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Day07 {

    public String partOne(String input) {
        Map<String, String[]> nodes = buildNodes(input);
        WeightedTree<String> nodeTree = buildTreeFromNodes(nodes);

        if (nodeTree != null && nodeTree.getNode() != null) {
            return nodeTree.getNode();
        } else {
            return "Could not build tree structure.";
        }
    }


    public String partTwo(String input) throws NoSuchMethodException {
        // TODO
        throw new NoSuchMethodException(input);
    }

    /**
     * TreeSet is ordered as such - each element E is a Map containing a 'name' key and a 'weight' value.
     *
     * @param nodes
     * @return
     */
    private WeightedTree<String> buildTreeFromNodes(Map<String, String[]> nodes) {
        Map<String, WeightedTree<String>> orphanedNodes = new HashMap<>();
        for (Map.Entry<String, String[]> node : nodes.entrySet()) {
            int weight = Integer.parseInt(node.getValue()[0]);
            WeightedTree<String> nodeTree = new WeightedTree<>(node.getKey(), weight);
//            System.out.println("New node: " + nodeTree.getNode() + " - " + StringUtils.join(Arrays.asList(node.getValue()), ","));

            if (node.getValue().length > 1) {
                for (int i = 0; i < node.getValue().length - 1; i++) {
                    nodeTree.addChildName(node.getValue()[i + 1]);
                }
            }
            orphanedNodes.put(nodeTree.getNode(), nodeTree);
        }

        String nodeName = "";
        for(Iterator<Map.Entry<String, WeightedTree<String>>> iterator = orphanedNodes.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, WeightedTree<String>> next = iterator.next();
            WeightedTree<String> node = next.getValue();
            nodeName = next.getKey();

            if (node.getChildrenNames() != null) {
                for (String childName : node.getChildrenNames()) {
                    WeightedTree<String> child = orphanedNodes.get(childName);
                    node.addChild(child);
                    child.setParentNode(node);
                }
            }
        }

        WeightedTree<String> node = orphanedNodes.get(nodeName);
        while(node.getParentNode() != null) {
            if(node.getParentNode().getNode() != null) {
                node = orphanedNodes.get(node.getParentNode().getNode());
            } else {
                System.out.println("ERROR: Something has gone wrong - " + node.getNode() + " parent has no name.");
            }
        }
        return node;
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
        private WeightedTree<String> parentNode;
        private final T node;
        private final int weight;
        private ArrayList<WeightedTree<T>> children;
        private ArrayList<String> childrenNames;

        public WeightedTree(T node, int weight) {
            this.node = node;
            this.weight = weight;
            children = new ArrayList<>();
            childrenNames = new ArrayList<>();
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

        public List<String> getChildrenNames() {
            return childrenNames;
        }

        public void addChildName(String name) {
            childrenNames.add(name);
        }

        public void setParentNode(WeightedTree<String> parentNode) {
            this.parentNode = parentNode;
        }

        public WeightedTree<String> getParentNode() {
            return parentNode;
        }
    }
}
