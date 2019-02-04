package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.*;

public class SynchronizedBuffCopy {
    private String fileName0 = "E:/example.txt";
    private String fileName1 = "E:/example2.txt";
    private final File source = new File(fileName0);
    private File dest = new File(fileName1);
    private int count;
    private long totalBytes;
    private final Thread read;
    private final Thread write;
    private byte[] buffer;

    public SynchronizedBuffCopy(int bufferSize){
        buffer = new byte[bufferSize];
        read = new Thread(() -> {
            try(FileInputStream in = new FileInputStream(source)) {
                try {
                    while (true){
                        synchronized (SynchronizedBuffCopy.this){
                            if(count == 0){
                                count = in.read(buffer);
                            }
                            if(count == -1){
                                break;
                            }
                        }
                    }
                }catch (IOException e){
                    count = -1;
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        write = new Thread(() -> {
            try(FileOutputStream out = new FileOutputStream(dest)) {
                try {
                    while (true){
                        synchronized (SynchronizedBuffCopy.this){
                            if(count > 0){
                                out.write(buffer,0,count);
                                totalBytes += count;
                                count = 0;
                            }
                            if(count == -1){
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
        });
    }
    public SynchronizedBuffCopy copy(){
        read.start();
        write.start();
        return this;
    }
    public SynchronizedBuffCopy join() throws InterruptedException {
        read.join();
        write.join();
        return this;
    }
    public long getTotalBytes(){
        return totalBytes;
    }

}
