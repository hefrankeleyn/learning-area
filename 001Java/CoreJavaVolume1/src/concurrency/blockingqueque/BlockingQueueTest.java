package concurrency.blockingqueque;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueueTest
 * @version 1.0 2019-02-17
 * @author Li Fei
 */
public class BlockingQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g volatile):");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    System.out.println("file DUMMY....");
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            };
            new Thread(enumerator).start();
            // search thread
            for (int i =1; i <= SEARCH_THREADS; i++){
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done){
                            // take() 移除并返回头元素，如果队列为空，则阻塞。
                            File file = queue.take();
                            if (file == DUMMY){
                                System.out.println(Thread.currentThread()+" over..");
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                };

                new Thread(searcher).start();
            }
        }
    }

    /**
     * Recursively enumerates all files in a given directory and its subdirectories.
     * @param directory the directory in witch to start
     * @throws InterruptedException
     */
    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }

    /**
     * Searchs a file for a given keyword and prints all matching lines.
     * @param file
     * @param keyword
     * @throws FileNotFoundException
     */
    public static void search(File file, String keyword) throws FileNotFoundException {
        try (Scanner in = new Scanner(file, "UTF-8")){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber ++;
                String line = in.nextLine();
                if (line.contains(keyword)){
                    System.out.printf("%s:%d:%s%n",file.getPath(), lineNumber, line);
                }
            }
        }
        
    }
}