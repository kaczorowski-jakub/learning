package performance;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SynchronizedCollections {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> setSynch = Collections.synchronizedSet(set);
        Set<Integer> setCopyWrite = new CopyOnWriteArraySet<Integer>(set);

        long beg = new Date().getTime();
        Meter m1 = new Meter(setSynch);
        Meter m2 = new Meter(setSynch);
        m1.start();
        m2.start();
        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long end = new Date().getTime();
        System.out.println(end - beg);
        System.out.println(setSynch);

        beg = new Date().getTime();
        m1 = new Meter(setCopyWrite);
        m2 = new Meter(setCopyWrite);
        m1.start();
        m2.start();
        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        end = new Date().getTime();
        System.out.println(end - beg);
        System.out.println(setCopyWrite);
    }

    static class Meter extends Thread {
        final Set<Integer> set;

        Meter(Set<Integer> set) {
            this.set = set;
        }

        @Override
        public void run() {
            while (set.size() < 100000) {
                set.add(new Random().nextInt());
            }
        }
    }
}
