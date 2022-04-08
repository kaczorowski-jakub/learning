package com.os.udemy.collections.collectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(50);
        list.add(102);
        
        modify(list);
        System.out.println(list);
        
        List<Integer> listUnmod = Collections.unmodifiableList(list);
        try {
            modify(listUnmod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void modify(List<Integer> list) {
        list.remove(0);
    }
    
    /**
     * this is an example of how to use unmodifiable collection
     * when we deal with it as a class field
     * @author jakub.kaczorowski
     *
     */
    private static class Node {
        private List<Node> nodes;
        
        public Node() {
            this.nodes = new ArrayList<>();
        }
        
        public List<Node> getNodes() {
            return Collections.unmodifiableList(nodes);
        }
    }
}
