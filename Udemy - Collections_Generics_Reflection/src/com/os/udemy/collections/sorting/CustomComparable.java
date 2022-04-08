package com.os.udemy.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparable {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Albert Camus", "title1", 223));
        books.add(new Book("Heidegger", "Being and time", 891));
        books.add(new Book("Michio Kaku", "Quantuum phisics", 34));
        books.add(new Book("Henryk Sienkiewicz", "W pustyni i w puszczy", 400));
        books.add(new Book("Henryk Sienkiewicz", "Krzyzacy", 300));
        
        System.out.println("Books before sort: " + books);
        Collections.sort(books);
        System.out.println("Books after sort: " + books);
        
        List<CompactDisk> cds = new ArrayList<>();
        cds.add(new CompactDisk("Thing", "RunDMC"));
        cds.add(new CompactDisk("Skrzydlaata", "Enej"));
        cds.add(new CompactDisk("Enej", "Enej"));
        
        System.out.println("CDs before sort: " + cds);
        Collections.sort(cds, (cd1, cd2) -> {
            if (cd1.artist.compareTo(cd2.artist) == 0) {
                return cd1.name.compareTo(cd2.name);
            } else {
                return cd1.artist.compareTo(cd2.artist);
            }
        });
        System.out.println("CDs after sort1: " + cds);
        
        cds.clear();
        cds.add(new CompactDisk("Thing", "RunDMC"));
        cds.add(new CompactDisk("Skrzydlaata", "Enej"));
        cds.add(new CompactDisk("Enej", "Enej"));
        Collections.sort(cds, new Comparator<CompactDisk>() {
            public int compare(CompactDisk o1, CompactDisk o2) {
                return o1.artist.compareTo(o2.artist);
            };
        });
        System.out.println("CDs after sort2: " + cds);
    }
    
    private static class CompactDisk {
        private String name;
        private String artist;
        
        public CompactDisk(String name, String artist) {
            this.name = name;
            this.artist = artist;
        }
        
        @Override
        public String toString() {
            return this.artist + " - " + this.name;
        }
    }
    
    private static class Book implements Comparable<Book> {
        private String authorName;
        private String title;
        private int numOfPages;

        public Book(String authorName, String title, int numOfPages) {
            this.authorName = authorName;
            this.title = title;
            this.numOfPages = numOfPages;
        }

        @Override
        public String toString() {
            return this.authorName + " - " + this.title + " - " + this.numOfPages;
        }

        @Override
        public int compareTo(Book o) {
            if (o == null) {
                return -1;
            } else if (this.authorName.equals(o.authorName)) {
                return this.title.compareTo(o.title);
            } else {
                return this.authorName.compareTo(o.authorName);
            }
        }
    }
}
