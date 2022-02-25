package com.os.udemy.collections.list;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * very similar to ArrayList
 * 
 * it is synchronized
 * 
 * @author jakub.kaczorowski
 *
 */
public class VectorTest {
    public static void main(String[] args) {
        List<String> vec1 = new Vector<>();
        vec1.addAll(Arrays.asList("1", "2", "ala", "ma", "kota"));
        System.out.println(vec1);

        Vector<String> vec2 = new Vector<>();
        vec2.addAll(Arrays.asList("1", "2", "ala", "ma", "kota"));
        System.out.println(vec2);
        
    }
}
