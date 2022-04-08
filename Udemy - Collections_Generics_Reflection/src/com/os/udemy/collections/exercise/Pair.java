package com.os.udemy.collections.exercise;

public class Pair {
    private String url;
    private String data;
    
    public Pair(String url, String data) {
        this.url = url;
        this.data = data;
    }
    
    public String getData() {
        return data;
    }
    
    public String getUrl() {
        return url;
    }
    
    @Override
    public String toString() {
        return url + " " + data;
    }
    
    @Override
    public int hashCode() {
        return url.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Pair) {
            Pair p = (Pair) obj;
            return this.url.equals(p.url);
        } else {
            return false;
        }
    }
}
