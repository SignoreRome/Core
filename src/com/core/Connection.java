package com.core;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Connection {
    private Semaphore semaphoreConnection = new Semaphore(10);
    private static int connectionCount;
    Lock lockConn = new ReentrantLock();
    private static Connection connection = new Connection();
    private Connection(){
    }

    public static Connection getConnection() {
        return connection;
    }

    public void work(){
        try {
            semaphoreConnection.acquire();
            doWork();
        } catch (InterruptedException e){
            System.out.println("Method doWork is interrupted");
        } finally {
            semaphoreConnection.release();
        }

    }

    public void doWork() throws InterruptedException {
        lockConn.lock();
        connectionCount++;
        System.out.println(connectionCount);
        System.out.println(Thread.currentThread().getName()+" has been connected");
        lockConn.unlock();
        Thread.sleep(2000);
        lockConn.lock();
        connectionCount--;
        System.out.println(Thread.currentThread().getName()+" has been disconnected");
        lockConn.unlock();

    }

    public int getConnectionCount(){
        return connectionCount;
    }
}
