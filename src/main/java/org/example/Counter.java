package org.example;


public class Counter {
    private int count;
    private int times;
    private boolean finished;


    public int getCount() {
        return count;
    }

    public synchronized void updateCount(int num) {
        this.count+= num;
        this.times++;
        if(this.times == Constants.ALL_UPDATES){
            this.finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }
}
