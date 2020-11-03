package com.core;

class SpaceShip implements Runnable {
    private int id;

    public SpaceShip(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(400);
            System.out.println(id + " spaceship is flying");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
