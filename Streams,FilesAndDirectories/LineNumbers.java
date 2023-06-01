package StreamsFilesAndDirectories;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader
                (".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
        PrintWriter pw=new PrintWriter(new FileWriter(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        String line=bf.readLine();
        int counter=1;
        while(line!=null){
            pw.println(counter+". "+line);
            counter++;
            line= bf.readLine();
        }
        bf.close();
        pw.close();

    }
}
