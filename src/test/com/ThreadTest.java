package com;

/**
 * Created by Administrator on 14-4-4.
 */
public class ThreadTest extends Thread {
    private int threadNo;

    public ThreadTest(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("threadNo="+threadNo+",i="+i);
        }
    }

    public static void main(String[] args) throws Exception{
        for(int i=0;i<10;i++){
            new ThreadTest(i).start();
            Thread.sleep(10000);
        }
    }
}
