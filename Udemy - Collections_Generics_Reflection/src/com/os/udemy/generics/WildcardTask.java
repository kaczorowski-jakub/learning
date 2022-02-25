package com.os.udemy.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardTask {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("ALA", "MA", "KOTA");
        List<String> list2 = Arrays.asList("KOT", "MA", "ALE");
        List<String> out = new ArrayList<>();
        copy(list1, out);
        copy(list2, out);
        System.out.println(out);
    }

    private static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T o : src) {
            dest.add(o);
        }
    }
}
