package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Object lock = new Object();

        for (int i = 0; i < Constants.THREAD_COUNT; i++) {
            Thread a = new Thread(new Action(counter,true,lock));
            Thread b = new Thread(new Action(counter,false,lock));
            a.start();
            Thread.sleep(1);
            b.start();
            b.join();
        }

        while(true){
            if(counter.isFinished()){
                System.out.println("Final: " + counter.getCount());
                break;
            }else{
                Thread.onSpinWait();
            }
        }

    }
}