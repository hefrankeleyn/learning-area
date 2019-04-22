package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe43;

import com.hef.algorithms.fundamentals.bags_queues_stacks.Queue;

import java.io.File;
import java.nio.file.Files;

/**
 * 1.3.43. Listing files. A folder is a list of files and folders. Write a program that takes the name of a folder as
 * a command-line argument and prints out all of the files contained in that folder, with the contents of each folder
 * recursively listed (indented) under that folder's name. Hint: Use a queue, and see java.io.File
 * @Date 2019-04-23
 * @Author lifei
 */
public class ListingFiles {

    public void readFold(String folder, Queue<File> files){
        File file = new File(folder);
        if(file.exists()){
            if(file.isFile()){
//                System.out.printf("%s\t", file.getName());
                files.enqueue(file);
            }else {
                files.enqueue(file);
//                System.out.printf("%s\r\n",file.getName());
                File[] foldfiles = file.listFiles();
                Queue<File> tempQ = new Queue<>();
                for (File f :
                        foldfiles) {
                    if(f.isFile()){
                        readFold(f.getPath(), files);
                    }else{
                        tempQ.enqueue(f);
                    }
                }
                for (File temp:
                     tempQ) {
                    readFold(temp.getPath(), files);
                }
            }
        }
    }


    public static void main(String[] args) {
        Queue<File> paths = new Queue<>();
        String folder = "/Users/lifei/Documents/workspace/learning-area/006Spring/pizza";
        ListingFiles listingFiles = new ListingFiles();
        listingFiles.readFold(folder, paths);
        int i = 0;
        for (File path :
                paths) {
            if(path.isDirectory()){
                if(i == 0){
                    String dirf = "%s\r\n";
                    System.out.printf(dirf, path.getName());
                }else{
                    String dirf = "%"+i+"s%s\r\n";
                    System.out.printf(dirf, " ",path.getName());
                }
                i ++;
            }else{
                if(i == 0){
                    String fileF = "%s\r\n";
                    System.out.printf(fileF, path.getName());
                }else{
                    String fileF = "%"+(i+1)+"s%s\r\n";
                    System.out.printf(fileF, " ", path.getName());
                }
            }
        }
    }
}
