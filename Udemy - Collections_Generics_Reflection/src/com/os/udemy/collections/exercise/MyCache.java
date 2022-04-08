package com.os.udemy.collections.exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyCache {
    
    private static final int CAP = 5;
    
    private final Queue<Pair> cache = new LinkedList<>();
    
    public static void main(String[] args) {
        MyCache mc = new MyCache();
        mc.search("google.com");
        mc.search("wp.pl");
        mc.search("onet.pl");
        mc.search("os.pl");
        mc.search("marker.pl");
        mc.printCache();
        
        System.out.println("Search for existing: " + mc.search("google.com"));
        mc.printCache();
        
        System.out.println("Search for not existing: " + mc.search("new.ru"));
        mc.printCache();
        
    }
    
    public String search(String url) {
        final Pair dummyPair = new Pair(url, "");
        if (!cache.contains(dummyPair)) {
            Pair newPair = new Pair(url, "random content" + (new Random().nextInt()));
            addPair(newPair);
            return newPair.getData();
        } else {
            return findElement(dummyPair).getData();
        }
    }
    
    private Pair findElement(Pair pair) {
        for (Pair p : cache) {
            if (p.equals(pair)) {
                return p;
            }
        }
        return null;
    }
    
    private void addPair(Pair pair) {
        if (cache.size() < CAP) {
            cache.add(pair);
        } else {
            cache.poll();
            cache.add(pair);
        }
    }
    
    public void printCache() {
        System.out.println("--------------------");
        System.out.println("Cache size: " + cache.size());
        for (Pair p : cache) {
            System.out.println(p);
        }
        System.out.println("--------------------");
    }
    
}
