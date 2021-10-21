package misc;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Test16 {
    public static void main(String[] args) {
        
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "an animal");
        table.put(new Word("dog"), "another animal");
        
        Enumeration<Word> e = table.keys();
        table.remove(new Word("dog"));
        while(e.hasMoreElements()) {
            Word key = e.nextElement();
            System.out.println(key.getWord());
        }
        
        table.put(new Word("cat"), "an animal");
        table.put(new Word("dog"), "another animal");
        Iterator<Word> it = table.keySet().iterator();
        table.remove(new Word("dog"));
        while (it.hasNext()) {
            Word key = it.next();
            System.out.println(key.getWord());
        }
    }
    
    private static class Word{
        private final String word;
        
        public Word(String word) {
            this.word = word;
        }
        
        public String getWord() {
            return word;
        }
        
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Word))
                return false;

            Word word = (Word) o;
            return word.getWord().equals(this.word);
        }
        
        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }
}
