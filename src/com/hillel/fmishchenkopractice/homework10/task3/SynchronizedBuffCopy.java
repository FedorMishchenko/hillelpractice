package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.*;

public class SynchronizedBuffCopy {
    private int count;
    private volatile int index;
    private volatile byte[] buffer;

    public SynchronizedBuffCopy(String fileNameOff, String fileNameDest,
                                int bufferSize, int readersCount,
                                int writersCount){
        File source = new File(fileNameOff);
        File dest = new File(fileNameDest);
        buffer = new byte[bufferSize];
        while (readersCount > 0){
            new Thread(() -> {
                try (FileInputStream in = new FileInputStream(source)) {
                    try {
                        index = 0;
                        while (true) {
                            synchronized (SynchronizedBuffCopy.this) {
                                if (count == 0) {
                                    count = in.read(buffer);
                                    index = buffer.length;
                                    print(": read");
                                }
                                if(index == bufferSize){
                                    notifyAll();
                                    wait(100);
                                }
                                if (count == -1) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException | InterruptedException e) {
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
                            synchronized (SynchronizedBuffCopy.this) {
                                if (count > 0) {
                                    out.write(buffer, 0, count);
                                    count = 0;
                                    print(": write");
                                }
                                if(isEmpty(buffer)){
                                    notifyAll();
                                    wait(100);
                                }
                                if (count == -1) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException | InterruptedException e) {
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
    private boolean isEmpty(byte[] buff){
        if(buff.length == 0){
            return true;
        }
        return false;
    }
    public void print(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }

}
