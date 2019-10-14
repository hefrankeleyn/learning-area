package com.hef.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 不需要显式的线程同步，在这个应用中，使用队列数据结构作为一种同步机制
 * 需求： 一个生成者线程递归读取目标下所有的文件； 开启多个消费者线程，每个搜索线程从队列中取出一个文件，打开它，打印所有包含关键字的行。
 * 然后取出下一个文件。使用一个技巧终止应用程序：当搜索线程取到虚拟对象的时候，将其放回并终止
 * @Date 2019/10/14
 * @Author lifei
 */
public class BlockingQuqueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);


    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g. /opt/jdk/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

            // 准备启动生产者线程
            Runnable enumerator = ()->{
                try {
                    enumerate(new File(directory));
                    // 放置一个虚拟对象到队列中
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            // 启动生产线程
            new Thread(enumerator).start();

            // 开启多个消费者线程
            for (int i=0; i<= SEARCH_THREADS; i++){
                Runnable searcher = () -> {
                    try{
                        boolean done = false;
                        // 当搜索线程取到这个虚拟对象时，将其放回并终止
                        while (!done){
                            File file = queue.take();
                            if (file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else {
                                search(file, keyword);
                            }
                        }
                    } catch (InterruptedException|FileNotFoundException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * 查询文件
     * @param file
     * @param keyworld
     * @throws FileNotFoundException
     */
    public static void search(File file, String keyworld) throws FileNotFoundException {
        try(Scanner in = new Scanner(file, "UTF-8")){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber ++;
                String line = in.nextLine();
                if(line.contains(keyworld)){
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }

    /**
     * 遍历目录下的所有文件，并将文件添加到阻塞队列中
     * 递归遍历目录
     * @param directory
     */
    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file: files) {
            if(file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }
}
