package StreamsFilesAndDirectories;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        PrintWriter pw=new PrintWriter(new FileWriter
                (".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        BufferedReader bf=new BufferedReader(new FileReader(
                ".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        bf.lines().forEach(line-> pw.println(line.toUpperCase()));
        bf.close();
        pw.close();

    }
}
