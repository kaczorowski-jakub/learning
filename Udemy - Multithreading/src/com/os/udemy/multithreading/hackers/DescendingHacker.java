package com.os.udemy.multithreading.hackers;

public class DescendingHacker extends Hacker {
    
    public DescendingHacker(Vault vault) {
        super(vault);
    }
    
    @Override
    public void run() {
        for (int guess = Vault.MAX_PASSWORD ; guess >= 0  ; guess++) {
            if (vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password: " + guess);
                System.exit(0);
            }
        }
    }
}
