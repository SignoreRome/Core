package com.core;

import java.util.Scanner;

public class NotifyAndWait {
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + " is started ...");
            lock.wait();
            System.out.println(Thread.currentThread().getName() + " is continued ...");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is over");
        }
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scan = new Scanner(System.in);
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+" is started ...");
            System.out.println("Waiting for press key");
            scan.nextLine();
            lock.notify();
            System.out.println(Thread.currentThread().getName() + " is over");
            Thread.sleep(1000);
        }
    }
}
