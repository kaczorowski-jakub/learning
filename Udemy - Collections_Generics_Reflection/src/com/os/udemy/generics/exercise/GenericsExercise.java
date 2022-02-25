package com.os.udemy.generics.exercise;

public class GenericsExercise {
    public static void main(String[] args) {
        Library<Algorithm> library = new Library<>();
        library.add(new GraphAlgorithm());
        library.add(new SortingAlgorithm());
        library.add(new SearchAlgorithm());
        
        Algorithm item;
        while ((item = library.getLast()) != null) {
            item.execute();
        }
        // the above is also achievable without generics
        
        // the thing which is not is when we want to user different libraries
        Library<GraphAlgorithm> libGA = new Library();
        Library<SortingAlgorithm> libSA = new Library();
        
    }
}
