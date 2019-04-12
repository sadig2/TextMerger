import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws IOException {

        System.out.println("enter first file1 name");

        Scanner in = new Scanner(System.in);
        String name1 = in.nextLine();
        File file1  = new File(name1+".txt");

        System.out.println("enter second file name");

         in = new Scanner(System.in);
        String name2 = in.nextLine();
        File file2  = new File(name2+".txt");


        SentenceCombiner sentenceCombiner = new SentenceCombiner(file1,file2);

        sentenceCombiner.readFiles();
        sentenceCombiner.createArrays();
        sentenceCombiner.outputFile();



    }


}
