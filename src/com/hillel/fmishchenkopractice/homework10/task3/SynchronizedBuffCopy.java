package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.*;

public class SynchronizedBuffCopy {
    private int count;
    private long totalBytes;
    private final Thread read;
    private final Thread write;
    private byte[] buffer;

    public SynchronizedBuffCopy(String fileNameIn,String fileNameOut,int bufferSize){
        File source = new File(fileNameIn);
        File dest = new File(fileNameOut);
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
