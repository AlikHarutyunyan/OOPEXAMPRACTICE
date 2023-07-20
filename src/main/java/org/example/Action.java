package org.example;

public class Action implements Runnable{
    private Counter counter;
    private final Object lock;
    private boolean toIncrement;
    public Action(Counter counter, boolean toIncrement, Object lock){
        this.counter = counter;
        this.toIncrement = toIncrement;
        this.lock = lock;
    }
    @Override
    public void run() {
        for (int i = 0; i < Constants.UPDATE_TIMES; i++) {
            synchronized (lock) {
                if (this.toIncrement) {
                    this.increment();
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this.decrement();
                    lock.notify();
                    if(i+1 != Constants.UPDATE_TIMES) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    private void increment(){
            this.counter.updateCount(1);
            System.out.println(this.counter.getCount());
    }
    private void decrement(){
            this.counter.updateCount(-1);
            System.out.println(this.counter.getCount());
    }




}
