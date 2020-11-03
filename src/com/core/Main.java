package com.core;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
//    private static BlockingQueue queue = new ArrayBlockingQueue(10);

    public static void main(String[] args) throws InterruptedException {
        Connection connection = Connection.getConnection();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            executorService.submit(()->{
                connection.work();
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.HOURS);




        /*NotifyAndWait nw = new NotifyAndWait();
        Thread thread1 = new Thread(() -> {
            try {
                nw.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                nw.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        /*ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<SpaceShip> spaceFlot = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            spaceFlot.add(new SpaceShip(i));
        }

        for(SpaceShip ss : spaceFlot){
            executorService.submit(ss);
        }

        System.out.println("All ships are ready");

        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.HOURS);*/
        // write your code here
    }

    /*private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take());
                System.out.println("Queue size is :" + queue.size());
            }
        }
    }*/
}




