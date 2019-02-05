package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncBuffCopy {
    private int count;
    /*private BlockingQueue buffer;*/
    private volatile byte[] buffer;
    /*ReentrantLock lock = new ReentrantLock(true);*/
    ReadWriteLock rwl = new ReentrantReadWriteLock(true);
    Lock readLock = rwl.readLock();
    Lock writeLock = rwl.writeLock();

    public SyncBuffCopy(String fileNameOff, String fileNameDest,
                        int bufferSize, int readersCount,
                        int writersCount){
        File source = new File(fileNameOff);
        File dest = new File(fileNameDest);
        buffer = new byte[bufferSize];
        while (readersCount > 0){
            new Thread(() -> {
                try (FileInputStream in = new FileInputStream(source)) {
                    try {
                        while (true) {
                            synchronized (this) {
                                if (count == 0) {
                                    read(in);
                                }
                                if (count == -1) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        count = -1;
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            readersCount--;
        }
        while (writersCount > 0){
            new Thread(() -> {
                try (FileOutputStream out = new FileOutputStream(dest)) {
                    try {
                        while (true) {
                            synchronized (this) {
                                if (count > 0) {
                                    write(out);
                                }
                                if (count == -1) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        count = -1;
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            writersCount--;
        }
    }

    public void read(FileInputStream in) throws IOException {
        readLock.lock();
        print(": lock");
        try {
            count = in.read(buffer);
            print(": read");
        }finally {
            print(": unlock");
            readLock.unlock();
        }
    }

    public void write(FileOutputStream out) throws IOException {
        writeLock.lock();
        print(": lock");
        try {
            out.write(buffer, 0, count);
            count = 0;
            print(": write");
        }finally {
            print(": unlock");
            writeLock.unlock();
        }
    }
    public void print(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }

}
