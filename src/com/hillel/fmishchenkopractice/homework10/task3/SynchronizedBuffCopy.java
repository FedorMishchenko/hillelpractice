package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.*;

public class SynchronizedBuffCopy {
    private int count;
    private long totalBytes;
    private byte[] buffer;

    public SynchronizedBuffCopy(String fileNameIn, String fileNameOut,
                                int bufferSize, int readThreadsCount,
                                int writeThreadsCount){
        File source = new File(fileNameIn);
        File dest = new File(fileNameOut);
        buffer = new byte[bufferSize];
        while (readThreadsCount > 0){
            new Thread(() -> {
                try (FileInputStream in = new FileInputStream(source)) {
                    try {
                        while (true) {
                            synchronized (SynchronizedBuffCopy.this) {
                                if (count == 0) {
                                    count = in.read(buffer);
                                    print(": read");
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
            readThreadsCount--;
        }
        while (writeThreadsCount > 0){
            new Thread(() -> {
                try (FileOutputStream out = new FileOutputStream(dest)) {
                    try {
                        while (true) {
                            synchronized (SynchronizedBuffCopy.this) {
                                if (count > 0) {
                                    out.write(buffer, 0, count);
                                    totalBytes += count;
                                    count = 0;
                                    print(": write");
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
            writeThreadsCount--;
        }
    }
    public void print(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }

}
