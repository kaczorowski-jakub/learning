package com.os.udemy.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("test 987", 987));
        books.add(new Book("test 100", 100));
        books.add(new Book("test 543", 643));

        Collections.sort(books, new BookComparator());
        System.out.println(books);
        
        Collections.sort(books, new BookComparator().reversed());
        System.out.println(books);
    }

    private static class Book {
        private String name;
        private int pages;

        public Book(String name, int pages) {
            this.name = name;
            this.pages = pages;
        }
        
        @Override
        public String toString() {
            return name + " -> " + pages;
        }
    }

    private static class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {

            return o1.pages - o2.pages;
        }

    }

}
