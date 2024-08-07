package com.alex.java基础;

public class 多线程交替打印 {

    private volatile boolean flag = true;

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        多线程交替打印 call = new 多线程交替打印();
        new Thread(()-> {
            try {
                call.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                call.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void printA() throws InterruptedException {
        synchronized (LOCK) {
            for (int i = 0; i < 10; i++) {
                if (flag) {
                    System.out.println("A");
                    flag = false;
                    LOCK.notifyAll();
                }

                LOCK.wait();
            }
        }
    }

    private void printB() throws InterruptedException {
        synchronized (LOCK) {
            for (int i = 0; i < 10; i++) {
                if (flag) {
                    LOCK.wait();
                }

                System.out.println("B");
                flag = true;
                LOCK.notifyAll();
            }
        }
    }
}
