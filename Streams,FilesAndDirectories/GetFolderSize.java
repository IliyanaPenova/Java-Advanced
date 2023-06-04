package StreamsFilesAndDirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;

public class GetFolderSize {
    public static void main(String[] args){
       File folder=new File(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");
        ArrayDeque<File> directories=new ArrayDeque<>();
        directories.offer(folder);

        int sumOfBytes=0;
        while(!directories.isEmpty()){
            File current=directories.poll();
            File[] files=current.listFiles();
            for (File entry : files) {
                if(entry.isDirectory()){
                    directories.offer(entry);
                }else{
                    sumOfBytes+= entry.length();
                }
                
            }
        }
        System.out.println("Folder size: "+sumOfBytes);
    }
}
