package org.example;


public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Object lock = new Object();

        //Task 1
        //Try to read and understand the code(try to guess what the last number should be), there is a bug in the code that results in incorrect output. Try to locate the problem and solve it.

        //Task 2 :
        //Now after you solved the bug print the last value of counter, but there is a catch: You cannot use Thread.sleep or join().
        // You only need to print one number (final number) and all the threads should work at the same time (that's why no join()) and you need to be sure that all of them are finished and not guess (that's why no Thread.sleep).

        //Task 3
        //Implement synchronized lock (wait, notify) logic in a way that it will print 1 then 0 each time until it reaches the end. You can use everything.

        for (int i = 0; i < Constants.THREAD_COUNT; i++) {
            Thread a = new Thread(new Action(counter,true,lock));
            Thread b = new Thread(new Action(counter,false,lock));
            a.start();
            b.start();
        }

    }
}