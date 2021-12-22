package com.os.udemy.multithreading.hackers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(Vault.MAX_PASSWORD));
        
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHacker(vault));
        threads.add(new DescendingHacker(vault));
        threads.add(new Policeman());

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
