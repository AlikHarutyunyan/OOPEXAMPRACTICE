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
            if (this.toIncrement) {
                this.increment();
            } else {
                this.decrement();
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
